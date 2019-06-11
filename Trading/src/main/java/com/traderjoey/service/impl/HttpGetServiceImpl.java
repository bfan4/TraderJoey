package com.traderjoey.service.impl;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.traderjoey.dto.RequestUrl;

public class HttpGetServiceImpl {
	protected RequestUrl url;
	protected CloseableHttpClient client = HttpClients.createDefault();
	protected String responseString;

	public HttpGetServiceImpl() {

	}

	public HttpGetServiceImpl(RequestUrl url) throws IOException {
		this.url = url;
		try {
			HttpGet httpGet = new HttpGet(url.urlString);
			CloseableHttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			client.close();
		}
	}
}
