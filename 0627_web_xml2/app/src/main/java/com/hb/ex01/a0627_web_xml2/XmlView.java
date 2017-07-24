package com.hb.ex01.a0627_web_xml2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by HB04-03 on 2017-06-27.
 */

public class XmlView extends Activity{
    TextView tv_xml;
    Handler handler = new Handler();
    String responseData;
    String msg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlview);
        tv_xml = (TextView)findViewById(R.id.tv_xml);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
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
            URL url = new URL("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");
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

    // DOM방식
    private void process(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(responseData)));
            NodeList local = document.getElementsByTagName("local");
            NodeList weather = document.getElementsByTagName("weather");
            String year = ((Element)weather.item(0)).getAttribute("year");
            String month = ((Element)weather.item(0)).getAttribute("month");
            String day = ((Element)weather.item(0)).getAttribute("day");
            String res = "일시 : "+year+"."+month+"."+day+"\n";
            res += "지명\t\t\t\t날씨\t\t\t\t온도\n";
            for(int i=0;i<local.getLength();i++){
                res += local.item(i).getTextContent()+"\t\t\t\t"+
                       ((Element)local.item(i)).getAttribute("desc")+"\t\t\t\t"+
                       ((Element)local.item(i)).getAttribute("ta")+"\n";
            }
            tv_xml.setText(res);
        }catch (Exception e){

        }
    }
}
