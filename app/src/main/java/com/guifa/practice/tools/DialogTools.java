package com.guifa.practice.tools;

/**
 * Created by GuiFa on 2017/9/11
 * dialog工具类
 */
public class DialogTools {

//    private static ProgressDialog mWaittingDialog;
//
//    public static void showWaittingDialog(Context context) {
//        try {
//            if (mWaittingDialog != null) {
//                mWaittingDialog.dismiss();
//                mWaittingDialog = null;
//            }
//
//            mWaittingDialog = new ProgressDialog(context, R.style.CustomProgressDialog);
//            mWaittingDialog.setCancelable(false);
//            LayoutInflater mInflater = mWaittingDialog.getLayoutInflater();
//            View mView = mInflater.inflate(R.layout.dialog_loading, null);
//            mWaittingDialog.show();
//            mWaittingDialog.setContentView(mView);
//            // 3秒后还未完成任务，则设置为可取消
//            TimerTask task = new TimerTask() {
//                @Override
//                public void run() {
//                    if (mWaittingDialog != null)
//                        mWaittingDialog.setCancelable(true);
//                }
//            };
//            Timer timer = new Timer(true);
//            timer.schedule(task, 3000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void closeWaittingDialog() {
//        try {
//            if (mWaittingDialog != null)
//                mWaittingDialog.dismiss();
//            mWaittingDialog = null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}