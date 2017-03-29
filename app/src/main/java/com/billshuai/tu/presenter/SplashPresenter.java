package com.billshuai.tu.presenter;

import android.util.Log;

import com.billshuai.tu.model.api.ApiService;
import com.billshuai.tu.model.entity.PicturesBean;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.observers.SafeSubscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Houge
 * tu
 */
public class SplashPresenter implements SplashContract.Presenter{
    private SplashContract.View view;
    private ApiService apiService;
    @Inject
    public SplashPresenter(SplashContract.View view, ApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }
    /**
     http://image.baidu.com/data/imgs?col=美女&tag=小清新&sort=0&pn=10&rn=10&p=channel&from=1
     * col=大类&tag=分类&sort=0&pn=开始条数&rn=显示数量&p=channel&from=1
     */
    @Override
    public void getImage() {
        String  col = "美女";
        String  tag = "小清新";
        int sort = 0;
        int pn = 10;
        int rn = 10;
        String  p = "channel";
        int from = 1;
        apiService.getPicture(col,tag,sort,pn,rn,p,from)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<PicturesBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("splash","load splash onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("splash","load splash onError");
                    }

                    @Override
                    public void onNext(PicturesBean picturesBean) {
                        if(picturesBean != null){
                            String imageUrl = picturesBean.getImgs().get(0).getImageUrl();
                            view.updateUI(imageUrl);
                        }
                    }
                });
    }
}
