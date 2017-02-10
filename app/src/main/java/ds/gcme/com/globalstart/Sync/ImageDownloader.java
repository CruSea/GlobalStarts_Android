package ds.gcme.com.globalstart.Sync;

import android.content.Context;
import android.os.AsyncTask;

import java.io.File;

/**
 * Created by BENGEOS on 3/18/16.
 */
public class ImageDownloader extends AsyncTask<String,String,String> {
    private String ImageURL,FileName;
    private Context myContext;
    private FileManager fileManager;
    private long FileSize;
    private boolean isRunning;
    public ImageDownloader(Context context, String image_url){
        ImageURL = image_url;
        fileManager = new FileManager(context);
        isRunning = false;
        myContext = context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        File file = myContext.getDir("GlobalStart", Context.MODE_PRIVATE);
        if(!file.exists()){
            file.mkdir();
        }
        FileSize = 0;
        isRunning = true;
    }
    public boolean isRunning(){
        return isRunning;
    }
    public void setImageURL(String file_name, String image_url){
        ImageURL = image_url;
        FileName = file_name;
    }

    @Override
    protected String doInBackground(String... params) {
//        int count = 0;
//        try{
//            URL url = new URL(ImageURL);
//            URLConnection connection = url.openConnection();
//            connection.connect();
//            connection.setReadTimeout(10000);
//            connection.setConnectTimeout(10000);
//            int fileSize = connection.getContentLength();
//
//            InputStream inputStream = new BufferedInputStream(url.openStream());
//            //File Dest = fileManager.Create_ImageFile(FileName);
//           // OutputStream outputStream = new FileOutputStream(Dest);
//            byte data[] = new byte[1024];
//            long total = 0;
//            while ((count = inputStream.read(data))!= -1){
//                total +=count;
//                outputStream.write(data,0,count);
//                FileSize = total;
//            }
//            outputStream.flush();
//            outputStream.close();
//            inputStream.close();
//        }catch (Exception e){
//            isRunning = false;
//        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        isRunning = false;
        super.onPostExecute(s);
    }
}
