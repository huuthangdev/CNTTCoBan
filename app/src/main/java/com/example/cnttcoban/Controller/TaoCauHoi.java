package com.example.cnttcoban.Controller;

import android.app.Activity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class TaoCauHoi {

    public static ArrayList<Question> createQuestions1(Activity activity){
        ArrayList<Question> listQuestion1 = new ArrayList<>();
        XmlPullParserFactory pullParserFactory;

        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            InputStream in_s = activity.getApplicationContext().getAssets().open("de1.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);
            listQuestion1 = readQuestionFromXml(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(listQuestion1);
        return listQuestion1;
    }

    public static ArrayList<Question> createQuestions2(Activity activity) {
        ArrayList<Question> listQuestion2 = new ArrayList<>();
        XmlPullParserFactory pullParserFactory;

        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            InputStream in_s = activity.getApplicationContext().getAssets().open("de2.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);
            listQuestion2 = readQuestionFromXml(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.shuffle(listQuestion2);
        return listQuestion2;
    }

    public static ArrayList<Question> createQuestions3(Activity activity) {
        ArrayList<Question> listQuestion3 = new ArrayList<>();
        XmlPullParserFactory pullParserFactory;

        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            InputStream in_s = activity.getApplicationContext().getAssets().open("de3.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);
            listQuestion3 = readQuestionFromXml(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(listQuestion3);
        return listQuestion3;
    }

    public static ArrayList<Question> createQuestions4(Activity activity) {
        ArrayList<Question> listQuestion4 = new ArrayList<>();
        XmlPullParserFactory pullParserFactory;

        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            InputStream in_s = activity.getApplicationContext().getAssets().open("de4.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);
            listQuestion4 = readQuestionFromXml(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(listQuestion4);
        return listQuestion4;
    }

    public static ArrayList<Question> createQuestions5(Activity activity) {
        ArrayList<Question> listQuestion5 = new ArrayList<>();
        XmlPullParserFactory pullParserFactory;

        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            InputStream in_s = activity.getApplicationContext().getAssets().open("de5.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);
            listQuestion5 = readQuestionFromXml(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(listQuestion5);
        return listQuestion5;
    }

    private static ArrayList<Question> readQuestionFromXml(XmlPullParser parser) throws XmlPullParserException, IOException {
        String text = "";
        ArrayList<Question> questionList = new ArrayList<>();
        int eventType = parser.getEventType();
        Question question = null;
        Map<String, String> answers = new HashMap<>();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String tagName = parser.getName();
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (tagName.equalsIgnoreCase("questionParse")) {
                        question = new Question();
                    }
                    break;

                case XmlPullParser.TEXT:
                    text = parser.getText();
                    break;

                case XmlPullParser.END_TAG:
                    if (tagName.equalsIgnoreCase("questionParse")) {
                        if (question != null) {
                            question.setAnswer(answers);
                        }
                        answers = new HashMap<>();
                        questionList.add(question);
                    } else if (tagName.equalsIgnoreCase("question")) {
                        if (question != null) {
                            question.setQuestion(text);
                        }
                    } else if (tagName.equalsIgnoreCase("a")) {
                        answers.put("1", text);
                    } else if (tagName.equalsIgnoreCase("b")) {
                        answers.put("2", text);
                    } else if (tagName.equalsIgnoreCase("c")) {
                        answers.put("3", text);
                    } else if (tagName.equalsIgnoreCase("d")) {
                        answers.put("4", text);
                    } else if (tagName.equalsIgnoreCase("reply")) {
                        if (question != null) {
                            question.setRightAnswer(text);
                        }
                    }
                    break;

                default:
                    break;
            }
            eventType = parser.next();
        }
        return questionList;
    }
}
