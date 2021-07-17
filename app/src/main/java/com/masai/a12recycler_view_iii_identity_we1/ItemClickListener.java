package com.masai.a12recycler_view_iii_identity_we1;
//parent class of all the class is object class
public interface ItemClickListener {

    void onItemClicked(int position, Employee employee);
}                                      //instead of Employee you can also write object

//After creating interface go to MainActivity and implement listener