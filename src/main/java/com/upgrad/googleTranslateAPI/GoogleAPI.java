package com.upgrad.googleTranslateAPI;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public abstract class GoogleAPI {


        protected static final String ENCODING = "UTF-8";


        protected static String referrer, key;


        public static void setHttpReferrer(final String pReferrer) {
            referrer = pReferrer;
        }


        public static void setKey(final String pKey) {
            key = pKey;
        }

        public static void validateReferrer() throws Exception {
            if (referrer == null || referrer.length() == 0) {
                throw new Exception("[google-api-translate-java] Referrer is not set. Call setHttpReferrer().");
            }
        }


        protected static JSONObject retrieveJSON(final URL url) throws Exception {
            try {
                final HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setRequestProperty("referer", referrer);
                uc.setRequestMethod("GET");
                uc.setDoOutput(true);



                try {
                    final String result = inputStreamToString(uc.getInputStream());

                    return new JSONObject(result);
                } finally { // http://java.sun.com/j2se/1.5.0/docs/guide/net/http-keepalive.html
                    uc.getInputStream().close();
                    if (uc.getErrorStream() != null) {
                        uc.getErrorStream().close();
                    }
                }
            } catch (Exception ex) {
                throw new Exception("[google-api-translate-java] Error retrieving translation.", ex);
            }
        }


        protected static JSONObject retrieveJSON(final URL url, final String parameters) throws Exception {
            try {
                final HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setRequestProperty("referer", referrer);
                uc.setRequestMethod("POST");
                uc.setDoOutput(true);
                uc.setRequestProperty("X-HTTP-Method-Override", "GET");

                final PrintWriter pw = new PrintWriter(uc.getOutputStream());
                pw.write(parameters);
                pw.close();
                uc.getOutputStream().close();

                try {
                    final String result = inputStreamToString(uc.getInputStream());

                    return new JSONObject(result);
                } finally { // http://java.sun.com/j2se/1.5.0/docs/guide/net/http-keepalive.html
                    if (uc.getInputStream() != null) {
                        uc.getInputStream().close();
                    }
                    if (uc.getErrorStream() != null) {
                        uc.getErrorStream().close();
                    }
                    if (pw != null) {
                        pw.close();
                    }
                }
            } catch (Exception ex) {
                throw new Exception("[google-api-translate-java] Error retrieving translation.", ex);
            }
        }


        private static String inputStreamToString(final InputStream inputStream) throws Exception {
            final StringBuilder outputBuilder = new StringBuilder();

            try {
                String string;
                if (inputStream != null) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, ENCODING));
                    while (null != (string = reader.readLine())) {
                        outputBuilder.append(string).append('\n');
                    }
                }
            } catch (Exception ex) {
                throw new Exception("[google-api-translate-java] Error reading translation stream.", ex);
            }

            return outputBuilder.toString();
        }
    }
}
