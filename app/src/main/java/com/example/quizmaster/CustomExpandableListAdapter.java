package com.example.quizmaster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;
//
//public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
//    private Context context;
//    private List<String> categoryList;
//    private Map<String, List<String>> subcategoryMap;
//
//    public CustomExpandableListAdapter(Context context, List<String> categoryList, Map<String, List<String>> subcategoryMap) {
//        this.context = context;
//        this.categoryList = categoryList;
//        this.subcategoryMap = subcategoryMap;
//    }
//
//    @Override
//    public int getGroupCount() {
//        return categoryList.size();
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//        return subcategoryMap.get(categoryList.get(groupPosition)).size();
//    }
//
//    @Override
//    public Object getGroup(int groupPosition) {
//        return categoryList.get(groupPosition);
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosition) {
//        return subcategoryMap.get(categoryList.get(groupPosition)).get(childPosition);
//    }
//
//    @Override
//    public long getGroupId(int groupPosition) {
//        return groupPosition;
//    }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition) {
//        return childPosition;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return true;
//    }
//
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, null);
//        }
//        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
//        textView.setText((String) getGroup(groupPosition));
//        textView.setTextSize(20f); // Larger text size for categories (groups)
//        textView.setMinHeight(120);
//        textView.setPadding(150, 5, 0, 5);
//        return convertView;
//    }
//
//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
//        }
//        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
//        textView.setText((String) getChild(groupPosition, childPosition));
//        // Decrease top and bottom padding
//        textView.setPadding(200, -5, 0, -5);  // Adjusted padding for top and bottom
//        textView.setTextSize(16f); // Smaller text size for subcategories (children)
//        return convertView;
//    }
//
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        return true;
//    }
//}

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Category> categoryList;

    public CustomExpandableListAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @Override
    public int getGroupCount() {
        return categoryList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return categoryList.get(groupPosition).getSubcategories().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return categoryList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return categoryList.get(groupPosition).getSubcategories().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, null);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(categoryList.get(groupPosition).getCategoryName());
        textView.setTextSize(20f); // Larger text size for categories (groups)
        textView.setMinHeight(120);
        textView.setPadding(150, 5, 0, 5);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        SubCategory subCategory = categoryList.get(groupPosition).getSubcategories().get(childPosition);
        textView.setText(subCategory.getSubCategoryName());
        // Decrease top and bottom padding
        textView.setPadding(200, -5, 0, -5);  // Adjusted padding for top and bottom
        textView.setTextSize(16f); // Smaller text size for subcategories (children)

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}