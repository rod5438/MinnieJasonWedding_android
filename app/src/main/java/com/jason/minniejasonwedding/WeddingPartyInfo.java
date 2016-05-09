package com.jason.minniejasonwedding;

import java.util.ArrayList;
import java.util.List;

enum WeddingPartyInfoType {
    Category, Info, Photo
}

public class WeddingPartyInfo {
    private String text;
    private WeddingPartyInfoType type;
    private int res;

    public WeddingPartyInfo(String text, WeddingPartyInfoType type) {
        this.text = text;
        this.type = type;
    }

    public WeddingPartyInfo(int res, WeddingPartyInfoType type) {
        this.res = res;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public WeddingPartyInfoType getType() {
        return type;
    }

    public void setType(WeddingPartyInfoType type) {
        this.type = type;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public static List<WeddingPartyInfo> generateTaipeiPartyInfoList(){
        List<WeddingPartyInfo> list = new ArrayList<>();
        list.add(new WeddingPartyInfo("宴會時間地點", WeddingPartyInfoType.Category));
        list.add(new WeddingPartyInfo("宴會日期：2016/05/21", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("餐廳：台北市儷宴會館", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("地址：台北市中山區林森北路413號", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo(R.drawable.restaurent_taipei, WeddingPartyInfoType.Photo));
        list.add(new WeddingPartyInfo("宴會活動流程", WeddingPartyInfoType.Category));
        list.add(new WeddingPartyInfo("觀禮：10:30", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("午宴：12:00", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("新人進場：12:30", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("抽獎：14:30", WeddingPartyInfoType.Info));

        return list;
    }

    public static List<WeddingPartyInfo> generateTaitungPartyInfoList(){
        List<WeddingPartyInfo> list = new ArrayList<>();
        list.add(new WeddingPartyInfo("觀禮時間地點", WeddingPartyInfoType.Category));
        list.add(new WeddingPartyInfo("觀禮日期：2016/04/16", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("觀禮時間：10:00", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("地點：台東基督長老教會", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("地址：台東縣廣東路329號", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("宴會時間地點", WeddingPartyInfoType.Category));
        list.add(new WeddingPartyInfo("宴會日期：2016/04/16", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("宴會時間：12:00", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("餐廳：台東市一家餐廳", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("地址：台東縣台東市更生路321號", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo(R.drawable.restaurent_taitung, WeddingPartyInfoType.Photo));
        list.add(new WeddingPartyInfo("宴會活動流程", WeddingPartyInfoType.Category));
        list.add(new WeddingPartyInfo("觀禮：10:00", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("午宴：12:00", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("新人進場：12:30", WeddingPartyInfoType.Info));
        list.add(new WeddingPartyInfo("抽獎：14:30", WeddingPartyInfoType.Info));

        return list;
    }
}