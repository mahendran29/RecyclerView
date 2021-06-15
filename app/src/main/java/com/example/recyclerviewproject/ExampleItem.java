package com.example.recyclerviewproject;

public class ExampleItem
{
    private int mImage;
    private String mtext1;
    private String mtext2;

    ExampleItem(int mImage,String mtext1,String mtext2)
    {
        this.mImage=mImage;
        this.mtext1=mtext1;
        this.mtext2=mtext2;
    }

    public void changeText(String text1)
    {
        mtext1=text1;
    }

    public int getmImage()
    {
        return mImage;
    }

    public String getMtext1()
    {
        return mtext1;
    }

    public String getMtext2()
    {
        return mtext2;
    }

}
