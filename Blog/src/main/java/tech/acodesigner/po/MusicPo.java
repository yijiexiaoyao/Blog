package tech.acodesigner.po;

/**
 *
 */
public class MusicPo {
    private int musicId;
    private String musicName;
    private String url;

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MusicPo{" +
                "musicId=" + musicId +
                ", musicName='" + musicName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
