package ds.gcme.com.globalstart.News_Feed;

/**
 * Created by BENGEOS on 3/17/16.
 */
public class NewsFeed_Object {
    private String NewsID,Title,Content,Image,Pub_Date;

    public NewsFeed_Object(){
        this.Title = "";
        this.Content = "";
    }
    public NewsFeed_Object(String newsID) {
        NewsID = newsID;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPub_Date() {
        return Pub_Date;
    }

    public void setPub_Date(String pub_Date) {
        Pub_Date = pub_Date;
    }

    public String getNewsID() {
        return NewsID;
    }

    public void setNewsID(String newsID) {
        NewsID = newsID;
    }
}
