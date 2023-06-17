package org.example;

public class ChartEntry
{
    private String rank;
    private String title;
    private String artist;

    public ChartEntry(String rank, String title, String artist)
    {
        this.rank = rank;
        this.title = title;
        this.artist = artist;
    }

    public String getRank()
    {
        return rank;
    }

    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }
}
