package jahirfiquitiva.iconshowcase.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pluscubed.recyclerfastscroll.RecyclerFastScroller;

import java.util.ArrayList;
import java.util.List;

import jahirfiquitiva.iconshowcase.R;
import jahirfiquitiva.iconshowcase.adapters.FAQsAdapter;
import jahirfiquitiva.iconshowcase.models.FAQsItem;
import jahirfiquitiva.iconshowcase.views.DividerItemDecoration;

public class FAQsFragment extends Fragment {

    public static String[] questions;
    public static String[] answers;

    List<FAQsItem> faqs;

    private ViewGroup layout;

    int cardsSpacing;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        if (layout != null) {
            ViewGroup parent = (ViewGroup) layout.getParent();
            if (parent != null) {
                parent.removeView(layout);
            }
        }
        try {
            layout = (ViewGroup) inflater.inflate(R.layout.faqs_section, container, false);
        } catch (InflateException e) {
            //Do nothing
        }

        questions = getResources().getStringArray(R.array.questions);
        answers = getResources().getStringArray(R.array.answers);

        faqs = new ArrayList<FAQsItem>();
        for (int i = 0; i < questions.length; i++) {
            FAQsItem item = new FAQsItem(questions[i], answers[i]);
            faqs.add(item);
        }

        cardsSpacing = getResources().getDimensionPixelSize(R.dimen.dividers_height);

        RecyclerView faqsList = (RecyclerView) layout.findViewById(R.id.faqs_list);

        FAQsAdapter faqsAdapter = new FAQsAdapter(faqs);
        faqsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        faqsList.setItemAnimator(new DefaultItemAnimator());
        faqsList.addItemDecoration(new DividerItemDecoration(getActivity(), null, cardsSpacing, false, false));
        faqsList.setHasFixedSize(true);
        faqsList.setAdapter(faqsAdapter);

        RecyclerFastScroller fastScroller = (RecyclerFastScroller) layout.findViewById(R.id.rvFastScroller);
        fastScroller.attachRecyclerView(faqsList);

        return layout;
    }

}