package com.example.android.miwok;

/**
 * 自定义填充item所需要用到的类
 */
public class Word {
    private String firstLanguage;
    private String secondtLanguage;
    private int ImageResourceId = NO_IMAGE_ID;
    private static final int NO_IMAGE_ID = -1;
    private int voiceResourceId;

    /*
    * 构造函数
    *
    * @param firstLanguage 第一语言
    * @param secondLanguage 第二语言
    * @param voiceResourceId 辅助识别语音
    * */
    public Word(String firstLanguage, String secondtLanguage,int voiceResourceId) {
        this.firstLanguage = firstLanguage;
        this.secondtLanguage = secondtLanguage;
        this.voiceResourceId = voiceResourceId;
    }

    /*
    * 构造函数
    *
    * @param firstLanguage 第一语言
    * @param secondLanguage 第二语言
    * @param imageResourceId 辅助识别图片
    * @param voiceResourceId 辅助识别语音
    * */
    public Word(String firstLanguage, String secondtLanguage, int ImageResourceId, int voiceResourceId) {
        this.firstLanguage = firstLanguage;
        this.secondtLanguage = secondtLanguage;
        this.ImageResourceId = ImageResourceId;
        this.voiceResourceId = voiceResourceId;
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
    * @return 返回这个word类的辅助识别图片的id
    * */
    public int getImageResourceId() {
        return ImageResourceId;
    }

    /*
    * 添加一个判断的方法，用来区分有图片和没有图片的listview
    * */
    public boolean hasImage() {
        return ImageResourceId != NO_IMAGE_ID;
    }

    /*
    * @return 返回这个word类的辅助识别语音的id
    * */
    public int getVoiceResourceId() {
        return voiceResourceId;
    }

    /*
    * toString方法会将所有这个类中的变量以string的类型返回
    * */
    @Override
    public String toString() {
        return "Word{" +
                "firstLanguage='" + firstLanguage + '\'' +
                ", secondtLanguage='" + secondtLanguage + '\'' +
                ", ImageResourceId=" + ImageResourceId +
                ", voiceResourceId=" + voiceResourceId +
                '}';
    }
}
