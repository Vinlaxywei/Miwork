package com.example.android.miwok;

/**
 * 自定义一个类，由两个TextView和一个ImageView组成，用于填充item
 */
public class Word {
    private String firstLanguage;
    private String secondtLanguage;
    private int ImageResourceId;

    /*
    * 构造函数
    *
    * @param firstLanguage 第一语言
    * @param secondLanguage 第二语言
    * */
    public Word(String firstLanguage, String secondtLanguage) {
        this.firstLanguage = firstLanguage;
        this.secondtLanguage = secondtLanguage;
    }

    /*
    * 构造函数
    *
    * @param firstLanguage 第一语言
    * @param secondLanguage 第二语言
    * @param ImageResourceId 辅助识别图片
    * */
    public Word(String firstLanguage, String secondtLanguage, int ImageResourceId) {
        this.firstLanguage = firstLanguage;
        this.secondtLanguage = secondtLanguage;
        this.ImageResourceId = ImageResourceId;
    }

    /*
    * @return 返回这个word类的第一语言
    * */
    public String getFirstLanguage() {
        return firstLanguage;
    }

    /*
    * @return 返回这个word类的第二语言
    * */
    public String getSecondtLanguage() {
        return secondtLanguage;
    }

    /*
    * @return 返回这个word类的辅助识别图片
    * */
    public int getImageResourceId() {
        return ImageResourceId;
    }
}
