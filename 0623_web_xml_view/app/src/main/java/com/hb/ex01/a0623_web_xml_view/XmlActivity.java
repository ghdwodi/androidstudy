package com.hb.ex01.a0623_web_xml_view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by HB04-03 on 2017-06-23.
 */

public class XmlActivity extends Activity{
    TextView tv_xml;
    Handler handler = new Handler();
    String responseData;
    String msg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_view);
        tv_xml = (TextView)findViewById(R.id.tv_xml);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                // 서버 접속
                callNetWork();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 서버에서 받은 정보를 파싱
                        process();
                    }
                });
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void callNetWork(){
        InputStream in = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://192.168.0.133:8090/Ex04_Web/MyController?type=xml");
            conn = (HttpURLConnection)url.openConnection();
            in = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuffer stringBuffer = new StringBuffer();
            while((msg=br.readLine())!=null){
                stringBuffer.append(msg);
            }
            responseData = stringBuffer.toString();
            Toast.makeText(this, "데이터", Toast.LENGTH_SHORT).show();
            br.close();
        }catch (Exception e){
            conn.disconnect();
        }
    }
    private void process(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(responseData)));
            NodeList person = document.getElementsByTagName("person");
            String res = null;
            res = "개인정보\n";
            for(int i=0;i<person.getLength();i++){
                res += ((Element)person.item(i)).getAttribute("idx")+","+
                        ((Element)person.item(i)).getAttribute("id")+","+
                        ((Element)person.item(i)).getAttribute("name")+","+
                        ((Element)person.item(i)).getAttribute("age")+","+
                        ((Element)person.item(i)).getAttribute("addr")+"\n";
            }
            tv_xml.setText(res);
        }catch (Exception e){

        }
    }
}
