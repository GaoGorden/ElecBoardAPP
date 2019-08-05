package p.gordenyou.elecboardapp.fragment.Material;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import p.gordenyou.elecboardapp.R;
import p.gordenyou.elecboardapp.RetrofitWebService.GetDataService;
import p.gordenyou.elecboardapp.RetrofitWebService.request.RequestModel;
import p.gordenyou.elecboardapp.view.SpinnerView;

public class PieFragment extends Fragment {

    @BindView(R.id.pie_warehouse)
    SpinnerView warehouse;

    private static final String TAG = "PieFragment";
    private String data = "";
    RequestModel requestModel;
    GetDataService getDataService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_materialpie, null);
        ButterKnife.bind(view);

        requestModel = new RequestModel("GetCompanyInfo");
        getDataService = new GetDataService(getContext(), TAG, requestModel);
        data = getDataService.GetData();

        requestModel = new RequestModel("GetMaterialKindCount_Gorden");
        getDataService = new GetDataService(getContext(), TAG, requestModel);
        data = getDataService.GetData();
//        ShowPieView(data);

        requestModel = new RequestModel("GetStockInfo_Gorden");
        getDataService = new GetDataService(getContext(), TAG, requestModel);
        data = getDataService.GetData();
//        ShowSpinner(data);

        return view;
    }

    private void ShowSpinner(String data) {
        if (!data.isEmpty()) {
            try {
                JSONArray jsonArray = new JSONObject(data).getJSONArray("StockInfo");
                String[] list_stock = new String[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++) {
                    String stockid = jsonArray.optJSONObject(i).getString("StockID");
                    String stockname = jsonArray.optJSONObject(i).getString("Stockname");
                    String temp = stockid + "_" + stockname;
                    list_stock[i] = temp;
                }
                warehouse.setSpinnerList(getContext(), list_stock);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void ShowPieView(String data) {
        if (!data.isEmpty()) {

        }
    }
}
