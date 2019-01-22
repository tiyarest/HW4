# AndroidLessonRestAPISolution

## 练习一：

**Been里定义一个类来接受调用接口的返回的json值。** 

@SerializedName("breeds")  

private ArrayList<String> list;   
  
@SerializedName("id")  

private String id;  

@SerializedName("url")  

private  String url;  

**定义一个接口实现get请求  **

@GET("search?limit=5") Call<List<Cat>>randomCat();  
  
**实例化一个Retrofit，异步Retrofit网络通信不用开启新的线程，可以不用考虑子线程不能修改ui。**  


                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.108.10.39:8080/")  
                
                .addConverterFactory(GsonConverterFactory.create())  
                
                .build();  
                
**调用get请求接口，同时更新ui**  
 
                retrofit.create(IMiniDouyinService.class)  
                .createVideo("3120181028","tianye", getMultipartFromUri("pic",mSelectedImage),getMultipartFromUri("vid",mSelectedVideo)) 
                . enqueue(new Callback<PostVideoResponse>() {  
                
                    @Override public void onResponse(Call<PostVideoResponse> call, Response<PostVideoResponse> response) {  
                    
                        Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");  
                        
                        Toast.makeText(Solution2C2Activity.this,"post vedio seccess",Toast.LENGTH_SHORT).show();  
                        

                    }  
                    
                    @Override public void onFailure(Call<PostVideoResponse> call, Throwable t) {  
                    
                        Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");  
                        
                        t.printStackTrace();  
                        
                    }  
                    
                });  
 ## 练习二： 
  
**网络Get请求接口调用方法如练习一。**

**网络Get请求接口调用如上：**  

@Multipart
    @POST("minidouyin/video/")
    Call<PostVideoResponse> createVideo(@Query("studengt_id")String studengtId ,
                                        @Query("user_name")String userName ,@Part MultipartBody.Part cover_image,
                                        @Part MultipartBody.Part video);
  
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://10.108.10.39:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    retrofit.create(IMiniDouyinService.class)   

       .createVideo("3120181028","tianye",getMultipartFromUri("pic",mSelectedImage)  
      
       ,getMultipartFromUri("vid",mSelectedVideo))  
       
       .enqueue(new Callback<PostVideoResponse>() {  
  
            @Override public void onResponse(Call<PostVideoResponse> call, Response<PostVideoResponse> response) {  
  
                Toast.makeText(Solution2C2Activity.this,"post vedio seccess",Toast.LENGTH_SHORT).show();
            }

            @Override public void onFailure(Call<PostVideoResponse> call, Throwable t) {
            }
        });


