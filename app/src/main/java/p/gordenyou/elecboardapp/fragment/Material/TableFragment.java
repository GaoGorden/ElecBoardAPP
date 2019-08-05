package p.gordenyou.elecboardapp.fragment.Material;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import p.gordenyou.elecboardapp.R;
import p.gordenyou.elecboardapp.RetrofitWebService.ApiStore;
import p.gordenyou.elecboardapp.RetrofitWebService.request.RequestBody;
import p.gordenyou.elecboardapp.RetrofitWebService.request.RequestEnvelope;
import p.gordenyou.elecboardapp.RetrofitWebService.request.RequestModel;
import p.gordenyou.elecboardapp.RetrofitWebService.response.AssetResponseBody;
import p.gordenyou.elecboardapp.RetrofitWebService.response.AssetResponseEnvelope;
import p.gordenyou.elecboardapp.RetrofitWebService.response.AssetResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class TableFragment extends Fragment {

    private static final String TAG = "PieFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_materialtable, null);
        GetData();
        return view;
    }

    private void GetData() {
        // 初始化Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.104/Huadian/")
                .addConverterFactory(SimpleXmlConverterFactory.create()) // 返回数据为xml,因此要加入xml解析
                .build();
        ApiStore apiStore = retrofit.create(ApiStore.class);
        // 初始化请求体
        RequestModel requestModel = new RequestModel("GetCompanyInfo");
        RequestBody requestBody = new RequestBody(requestModel);
        RequestEnvelope requestEnvelope = new RequestEnvelope(requestBody);
        // 开始请求
        Call<AssetResponseEnvelope> call = apiStore.getAssetInfo(requestEnvelope);
        call.enqueue(new Callback<AssetResponseEnvelope>() {
            @Override
            public void onResponse(Call<AssetResponseEnvelope> call, Response<AssetResponseEnvelope> response) {
                // 处理响应体
                AssetResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope == null) {
                    Log.d(TAG, "onResponse: responseEnvelope == null");
                    return;
                }
                AssetResponseBody responseBody = responseEnvelope.responseBody;
                if (responseBody == null) {
                    Log.d(TAG, "onResponse: responseBody == null");
                    return;
                }
                AssetResponseModel responseModel = responseBody.responseModel;
                if (responseModel == null) {
                    Log.d(TAG, "onResponse: responseModel == null");
                    return;
                }
                String result = responseModel.GetAppDataResult;
                Log.d(TAG, "onResponse: result : " + result);
//                showResult(result);
            }

            @Override
            public void onFailure(Call<AssetResponseEnvelope> call, Throwable t) {

            }
        });
    }
}
