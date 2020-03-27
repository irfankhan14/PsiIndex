package com.irfan.singapore.ui.home;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.irfan.singapore.R;
import com.irfan.singapore.adapter.ReadingItemsAdapter;
import com.irfan.singapore.model.PsiResponse;
import com.irfan.singapore.model.Readings;
import com.irfan.singapore.model.RegionMetadatum;
import com.irfan.singapore.viewmodel.home.HomeViewModel;
import com.irfan.singapore.utils.CustomItemDecoration;
import com.irfan.singapore.utils.ReadingListDetails;

public class HomeFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private HomeViewModel homeViewModel;
    private GoogleMap googleMap;
    private Readings readings;
    private PsiResponse psiResponse;
    private SupportMapFragment mMapFragment;
    private Dialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        // Initialize View Model
        initializeViewModel();

        // Adding Observers to View Model
        addObservers();

        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void addObservers() {
        // get response from the api
        homeViewModel
                .getResponseData()
                .observe(getViewLifecycleOwner(), response -> {
                    psiResponse = response;
                    readings = response.getItems().get(0).getReadings();
                    mMapFragment.getMapAsync(HomeFragment.this::onMapReady);
                });

        // handle on response error
        homeViewModel
                .getErrorMessage()
                .observe(getViewLifecycleOwner(), text -> Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show());

        // dialog show and dismiss, on App load and after API response
        homeViewModel
                .getProgressDialog()
                .observe(getViewLifecycleOwner(), value -> displayProgressDialog(value));
    }

    private void initializeViewModel() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;

        // get response data and add Markers to it
        for (int i = 0; i < psiResponse.getRegionMetadata().size(); i++) {
            if (!psiResponse.getRegionMetadata().get(i).getName().equals(getActivity().getResources().getString(R.string.national_string))) {
                drawMarkers(psiResponse.getRegionMetadata().get(i));
            }
        }

        // Get first Latitude & Longitude of response
        LatLng latLngTest = new LatLng(
                psiResponse.getRegionMetadata().get(0).getLabelLocation().getLatitude(),
                psiResponse.getRegionMetadata().get(0).getLabelLocation().getLongitude());

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngTest, 10f));
        googleMap.setOnInfoWindowClickListener(this);

    }

    private void drawMarkers(RegionMetadatum regionMetadatum) {
        LatLng latLng = new LatLng(regionMetadatum.getLabelLocation().getLatitude(), regionMetadatum.getLabelLocation().getLongitude());
        String title = getActivity().getResources().getString(R.string.marker_title_string) + " " + regionMetadatum.getName();
        googleMap.addMarker(new MarkerOptions().position(latLng).title(title));
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        // Add a dialog window on click of Marker
        Dialog readingsdialog = new Dialog(getActivity());
        readingsdialog.setContentView(R.layout.dialog_reading_details);
        readingsdialog.setCancelable(true);

        TextView readingsTitle = readingsdialog.findViewById(R.id.readingsTitle);
        RecyclerView recyclerViewReadings = readingsdialog.findViewById(R.id.recyclerViewReadings);

        // Set a recyclerview in dialog
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewReadings.setLayoutManager(mLayoutManager);

        // Add divider between items in recyclerview
        CustomItemDecoration customItemDecoration = new CustomItemDecoration(getActivity(),
                R.dimen.margin4);
        recyclerViewReadings.addItemDecoration(customItemDecoration);

        readingsTitle.setText(ReadingListDetails.getRegionTitle(marker.getTitle()).toUpperCase() + " Region Readings");

        // Set adapter in recyclerview
        ReadingItemsAdapter homePageAdapter = new ReadingItemsAdapter(
                ReadingListDetails.getReadingDetails(readings,
                ReadingListDetails.getRegionTitle(marker.getTitle())));
        recyclerViewReadings.setAdapter(homePageAdapter);

        readingsdialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void displayProgressDialog(boolean display) {
        // display loading dialog on App Start
        if (dialog == null) {
            dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.loading_message);
            dialog.setCancelable(false);
        }

        if (display) {
            dialog.show();
        } else {
            dialog.dismiss();
        }
    }
}
