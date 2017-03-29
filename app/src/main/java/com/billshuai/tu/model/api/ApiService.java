package com.billshuai.tu.model.api;

import com.billshuai.tu.model.entity.PicturesBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Houge on 2017/3/28.
 */

public interface ApiService {
   /**
    http://image.baidu.com/data/imgs?col=美女&tag=小清新&sort=0&pn=10&rn=10&p=channel&from=1
    * col=大类&tag=分类&sort=0&pn=开始条数&rn=显示数量&p=channel&from=1
    */
   /**
    * @param col
    * @param tag
    *@param sort
    * @param pn
    * @param channel
    * @param from     @return
    */
   @GET("data/imgs")
   Observable<PicturesBean> getPicture(@Query("col") String col, @Query("tag") String tag,
                                       @Query("sort") int sort, @Query("pn") int pn,@Query("rn") int rn,
                                       @Query("p") String channel, @Query("from") int from);

}
