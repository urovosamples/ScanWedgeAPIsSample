package com.ubx.scanwedge.intentapi;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.device.scanner.configuration.Category;
import android.device.scanner.configuration.IntentKeys;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Set;

/**
 * This application is intended for demonstration purposes only. It is provided as-is  without guarantee or warranty and may be modified to suit individual needs.
 * ScanWedge intent api introduced in V2.1.19_20230220
 * Sample supporting ScanWedge APIs up to Android 10 and higher,OS release on 20230220 and higher.
 */
public class MainActivity extends AppCompatActivity {
    String TAG = "WedgeIntentAPI";
    EditText uriShare;
    private BroadcastReceiver mScanReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String command = intent.getStringExtra(IntentKeys.RESULT_ACTION_EXTRA_COMMAND);
            Log.d("API_RESULT_ACTION", " command: " + command);
            if(IntentKeys.ACTION_EXTRA_IMPORT_CONFIG.equals(command)) {
                receiveImportResult(command, intent);
            } else if(IntentKeys.ACTION_EXTRA_GET_PROFILES_LIST.equals(command)) {
                if (intent.hasExtra(IntentKeys.RESULT_ACTION_EXTRA_GET_PROFILES_LIST)) {
                    String[] profilesList = intent.getStringArrayExtra(IntentKeys.RESULT_ACTION_EXTRA_GET_PROFILES_LIST);
                    String resultInfo = "";
                    for (String key: profilesList) {
                        resultInfo += key + "\n";
                    }
                    String text = "Command: "+command+"\n" +
                            "profilesList: " +resultInfo;
                    uriShare.setText(text);
                }
            } else if(IntentKeys.ACTION_EXTRA_GET_ACTIVE_PROFILE.equals(command)) {
                String activeProfile = intent.getStringExtra(IntentKeys.RESULT_ACTION_EXTRA_GET_ACTIVE_PROFILE);
                String text = "Command: "+command+"\n" +
                        "activeProfile: " +activeProfile;
                uriShare.setText(text);
            } else if(IntentKeys.ACTION_EXTRA_GET_SCANNER_STATUS.equals(command)) {
                String activeProfile = intent.getStringExtra(IntentKeys.RESULT_ACTION_EXTRA_GET_SCANNER_STATUS);
                String text = "Command: "+command+"\n" +
                        "scannerStatus: " +activeProfile;
                uriShare.setText(text);
            } else if(IntentKeys.ACTION_EXTRA_GET_SCANWEDGE_STATUS.equals(command)) {
                String activeProfile = intent.getStringExtra(IntentKeys.RESULT_ACTION_EXTRA_GET_SCANWEDGE_STATUS);
                String text = "Command: "+command+"\n" +
                        "ScanWedgeStatus: " +activeProfile;
                uriShare.setText(text);
            } else if(IntentKeys.ACTION_EXTRA_GET_CONFIG.equals(command)) {
                receiveGetConfigResult(command, intent);
            } else if(IntentKeys.ACTION_EXTRA_SET_CONFIG.equals(command)) {
                receiveSetConfigResult(command, intent);
            } else {
                String result = intent.getStringExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT);
                String resultInfo = "";
                if(intent.hasExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT_INFO)){
                    Bundle bundle = intent.getBundleExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT_INFO);
                    Set<String> keys = bundle.keySet();
                    if(keys != null) {
                        for (String key: keys) {
                            Object resultCode = bundle.get(key);
                            if(resultCode instanceof String){
                                String code = (String)resultCode;
                                resultInfo += key + ": "+code + "\n";
                            }else if(resultCode instanceof String[]){
                                String[] codesArray = (String[])resultCode;
                                if(codesArray!=null){
                                    resultInfo += key + ": " + "\n";
                                    for(String code : codesArray){
                                        resultInfo += code + "\n";
                                    }
                                }
                            }
                        }
                    }
                }

                String text = "Command: "+command+"\n" +
                        "Result: " +result+"\n" +
                        "Result Info: " +resultInfo + "\n";
                uriShare.setText(text);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uriShare = (EditText) findViewById(R.id.uriShare);
        requestPermissions(99);
        Button CLONE_PROFILE = (Button) findViewById(R.id.button);
        CLONE_PROFILE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cloneProfile();
            }
        });
        Button create_PROFILE = (Button) findViewById(R.id.button2);
        create_PROFILE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProfile();
            }
        });
        Button del_PROFILE = (Button) findViewById(R.id.button3);
        del_PROFILE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteProfile();
            }
        });
        Button renameProfile = (Button) findViewById(R.id.button4);
        renameProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                renameProfile();
            }
        });
        Button importProfile = (Button) findViewById(R.id.button5);
        importProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                importProfile();
            }
        });
        Button restoreScanWedge = (Button) findViewById(R.id.button6);
        restoreScanWedge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restoreScanWedge();
            }
        });


        Button setConfig1 = (Button) findViewById(R.id.button7);
        setConfig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSingleCategoryForProfile();
            }
        });

        Button setConfig2 = (Button) findViewById(R.id.button19);
        setConfig2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMultipleCategoryForProfile();
            }
        });


        Button GetScanWedgeStatus = (Button) findViewById(R.id.button12);
        GetScanWedgeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntentWithExtra(IntentKeys.ACTION_EXTRA_GET_SCANWEDGE_STATUS, "");
            }
        });

        Button GetCurrentProfile = (Button) findViewById(R.id.button13);
        GetCurrentProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntentWithExtra(IntentKeys.ACTION_EXTRA_GET_ACTIVE_PROFILE, "");
            }
        });
        Button GetScannerStatus = (Button) findViewById(R.id.button14);
        GetScannerStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntentWithExtra(IntentKeys.ACTION_EXTRA_GET_SCANNER_STATUS, "");
            }
        });
        Button GetProfilesList = (Button) findViewById(R.id.button15);
        GetProfilesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntentWithExtra(IntentKeys.ACTION_EXTRA_GET_PROFILES_LIST, "");
            }
        });
        Button GetConfig1 = (Button) findViewById(R.id.button16);
        GetConfig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetConfig1();
            }
        });
        Button GetConfig2 = (Button) findViewById(R.id.button17);
        GetConfig2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetConfig2();
            }
        });
        Button GetConfig3 = (Button) findViewById(R.id.button18);
        GetConfig3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetConfig3();
            }
        });


        Button EnableDataWedge = (Button) findViewById(R.id.button8);
        EnableDataWedge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(IntentKeys.API_ACTION);
                i.putExtra(IntentKeys.ACTION_EXTRA_ENABLE_SCANWEDGE,true);
                i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
                sendBroadcast(i);
            }
        });
        Button ResetDefaultProfile = (Button) findViewById(R.id.button9);
        ResetDefaultProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntentWithExtra(IntentKeys.ACTION_EXTRA_RESET_DEFAULT_PROFILE, "");
            }
        });
        Button triggerStart = (Button) findViewById(R.id.button10);
        triggerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntentWithExtra(IntentKeys.ACTION_EXTRA_SOFT_SCAN_TRIGGER, IntentKeys.API_START_SCANNING);
            }
        });
        Button triggerStop = (Button) findViewById(R.id.button21);
        triggerStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntentWithExtra(IntentKeys.ACTION_EXTRA_SOFT_SCAN_TRIGGER, IntentKeys.API_STOP_SCANNING);
            }
        });
        Button SwitchProfile = (Button) findViewById(R.id.button11);
        SwitchProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntentWithExtra(IntentKeys.ACTION_EXTRA_SWITCH_TO_PROFILE, "my1");
            }
        });
        Button  SwitchScannerParams = (Button) findViewById(R.id.button20);
        SwitchScannerParams.setVisibility(View.GONE);
        SwitchScannerParams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchScannerParams();
            }
        });
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        unregisterReceiver(mScanReceiver);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(IntentKeys.API_RESULT_ACTION); // for error code result
        filter.addCategory(Intent.CATEGORY_DEFAULT);    // needed to get version info
        registerReceiver(mScanReceiver, filter);
    }
    private void sendIntentWithExtra(String extraKey, String extraValue)
    {
        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(extraKey, extraValue);
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        this.sendBroadcast(i);
    }
    private void sendDataWedgeIntentWithExtra(String extraKey, Bundle extras)
    {
        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(extraKey, extras);
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        this.sendBroadcast(i);
    }
    private void cloneProfile(){
        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        String[ ] values = {"Default","cloneProfile"};//Name of Profile to be copied, new Profile name
        i.putExtra(IntentKeys.ACTION_EXTRA_CLONE_PROFILE, values);
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        this.sendBroadcast(i);
    }
    private void createProfile(){
        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(IntentKeys.ACTION_EXTRA_CREATE_PROFILE, "App1Profile");
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        this.sendBroadcast(i);
    }
    //Used to delete an existing deletable Profile, no including the "Default" Profile.
    //WARNING: Supports use of the wildcard character (“*”), which deletes all deletable Profiles from the configuration, no including the "Default" Profile.
    private void deleteProfile() {
        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(IntentKeys.ACTION_EXTRA_DELETE_PROFILE, "cloneProfile");
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        this.sendBroadcast(i);
    }
    private void renameProfile() {
        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        String[] values = {"App1Profile","App2Profile"};//Profile name to be renamed, New Profile name
        i.putExtra(IntentKeys.ACTION_EXTRA_RENAME_PROFILE, values);
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        this.sendBroadcast(i);

    }

    /**
     * Used to import a ScanWedge Profile and/or Config settings files.
     * A Profile is a single group of settings that control how ScanWedge will behave with one or more specific applications and devices.
     * A Config file can contain numerous Profiles, and stores all other ScanWedge settings, including its status (enabled/disabled), logging and other configurable parameters.
     */
    private void importProfile() {
        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(IntentKeys.ACTION_EXTRA_IMPORT_CONFIG, "");
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        ArrayList<String> fileNames = new ArrayList<>();
        fileNames.add("sdcard/myprofile/my1_scanner_property.xml");
        fileNames.add("sdcard/myprofile/my2_scanner_property.xml");
        i.putStringArrayListExtra(IntentKeys.ACTION_EXTRA_FILE_LIST, fileNames);
        this.sendBroadcast(i);

    }
    private void restoreScanWedge() {
        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(IntentKeys.ACTION_EXTRA_RESTORE_CONFIG, "");
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        this.sendBroadcast(i);

    }

    private void GetConfig1() {
        Bundle bMain = new Bundle();
        bMain.putString(IntentKeys.BUNDLE_EXTRA_PROFILE_NAME, "my1");
        bMain.putString(IntentKeys.BUNDLE_EXTRA_APP_LIST, "");//empty

        Bundle bConfig = new Bundle();
        ArrayList<String> categoryName = new ArrayList<>();
        categoryName.add(Category.CAT_OUTPUT);

        bConfig.putStringArrayList(IntentKeys.BUNDLE_EXTRA_CATEGORY_NAME, categoryName);
        bMain.putBundle(IntentKeys.BUNDLE_EXTRA_CATEGORY_CONFIG, bConfig);

        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(IntentKeys.ACTION_EXTRA_GET_CONFIG, bMain);
        this.sendBroadcast(i);
    }
    private void GetConfig2() {
        Bundle bMain = new Bundle();
        bMain.putString(IntentKeys.BUNDLE_EXTRA_PROFILE_NAME, "my1");
        //bMain.putString(IntentKeys.BUNDLE_EXTRA_APP_LIST, "");//empty

        Bundle bConfig = new Bundle();
        ArrayList<String> categoryName = new ArrayList<>();
        categoryName.add(Category.CAT_READER);
        categoryName.add(Category.CAT_FORAMT);

        bConfig.putStringArrayList(IntentKeys.BUNDLE_EXTRA_CATEGORY_NAME, categoryName);
        bMain.putBundle(IntentKeys.BUNDLE_EXTRA_CATEGORY_CONFIG, bConfig);

        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(IntentKeys.ACTION_EXTRA_GET_CONFIG, bMain);
        this.sendBroadcast(i);
    }
    private void GetConfig3() {
        Bundle bMain = new Bundle();
        bMain.putString(IntentKeys.BUNDLE_EXTRA_PROFILE_NAME, "my1");
        //bMain.putString(IntentKeys.BUNDLE_EXTRA_APP_LIST, "");//empty

        Bundle bConfig = new Bundle();
        ArrayList<String> categoryName = new ArrayList<>();
        categoryName.add(Category.CAT_DECODER);

        bConfig.putStringArrayList(IntentKeys.BUNDLE_EXTRA_CATEGORY_NAME, categoryName);
        bMain.putBundle(IntentKeys.BUNDLE_EXTRA_CATEGORY_CONFIG, bConfig);

        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(IntentKeys.ACTION_EXTRA_GET_CONFIG, bMain);
        this.sendBroadcast(i);
    }
    //Temporarily update the settings of the active profile during runtime by passing one or more barcode, scanner and/or reader parameters as intent
    private void SwitchScannerParams() {

    }
    /**
     * Used to create, update or replace a ScanWedge Profile and its settings, and can configure multiple options with a single intent action.
     * {@link IntentKeys#ACTION_EXTRA_SET_CONFIG} implements nested bundles,
     * where a PARAM_LIST (parameter list) bundle can be nested within its corresponding {@link IntentKeys#BUNDLE_EXTRA_CATEGORY_CONFIG}
     * (option based on Reader, data processing, utilities, or output) bundle, which can then be nested within the main SET_CONFIG bundle.
     * Multiple CATEGORY_NAME bundles can be nested within the SET_CONFIG bundle.
     * Bundle数据内容结构
     * mainBundle
     *      BUNDLE_EXTRA_PROFILE_NAME 配置文件名称
     *      CONFIG_MODE　[String]　对配置文件处理方式(默认操作　UPDATE)
     *      　　　OVERWRITE　重置所有参数后，再进行配置
     *      　　　UPDATE　　　在更新需要配置的参数项
     *      　　　CREATE_IF_NOT_EXIST　如果配置文件名不存在，则创建并配置参数
     *      BUNDLE_EXTRA_APP_LIST　ArrayList<Bundle> 绑定到该配置文件的app列表
     *           appBundle:每个bundle对应一个app并包含如下信息
     *        　　PACKAGE_NAME　[String]
     *        　　ACTIVITY_LIST　ArrayList<String> 绑定app Activity界面列表，如果为　“*”,则表示app中的任何界面与该profile配置文件关联
     *      BUNDLE_EXTRA_CATEGORY_CONFIG ArrayList<Bundle>参数设置类别列表
     *      　　categoryBundle 每个类别对应一个Bundle
     *             BUNDLE_EXTRA_CATEGORY_NAME 类别名称：(FORAMT/OUTPUT/READER 与扫描头内部无关) DECODER 需要设置到扫描头内部
     *      *             BUNDLE_EXTRA_PARAM_LIST bParams Bundle object
     *                        bParams <name, value>键值对参数列表，比如：
     *      *                bParams.putString("WEDGE_INTENT_ACTION_NAME", "android.intent.ACTION_DECODE_DATA");
     *      *                bParams.putInt(WEDGE_KEYBOARD_ENABLE, 1);
     *
     */
    private void setMultipleCategoryForProfile() {
        Bundle bMain = new Bundle();
        bMain.putString(IntentKeys.BUNDLE_EXTRA_PROFILE_NAME,"Profile5");
        bMain.putString(IntentKeys.BUNDLE_EXTRA_PROFILE_ENABLED, "true");
        bMain.putString(IntentKeys.BUNDLE_EXTRA_CONFIG_MODE,IntentKeys.PROFILE_CONFIG_MODE_CREATE_IF_NOT_EXIST);

        ArrayList<Bundle> appList = new ArrayList<>();

        Bundle bundleApp1 = new Bundle();
        bundleApp1.putString(IntentKeys.BUNDLE_EXTRA_PACKAGE_NAME,"com.android.phone");
        bundleApp1.putStringArray(IntentKeys.BUNDLE_EXTRA_ACTIVITY_LIST, new String[]{"*"});

        appList.add(bundleApp1);
        Bundle bundleApp2 = new Bundle();
        bundleApp2.putString(IntentKeys.BUNDLE_EXTRA_PACKAGE_NAME,"com.android.dialer");
        bundleApp2.putStringArray(IntentKeys.BUNDLE_EXTRA_ACTIVITY_LIST, new String[]{"*"});

        appList.add(bundleApp2);

        bMain.putParcelableArrayList("APP_LIST",appList);

        ArrayList<Bundle> categoryList = new ArrayList<>();

        Bundle outputConfig = new Bundle();
        outputConfig.putString(IntentKeys.BUNDLE_EXTRA_CATEGORY_NAME, Category.CAT_OUTPUT);
        Bundle intentProps = new Bundle();
        intentProps.putInt(Category.OutPut.WEDGE_KEYBOARD_ENABLE, 0);
        intentProps.putString(Category.OutPut.WEDGE_INTENT_ACTION_NAME, "my.ACTION");
        outputConfig.putBundle(IntentKeys.BUNDLE_EXTRA_PARAM_LIST, intentProps);
        categoryList.add(outputConfig);

        Bundle decoderConfig = new Bundle();
        decoderConfig.putString(IntentKeys.BUNDLE_EXTRA_CATEGORY_NAME, Category.CAT_OUTPUT);

        Bundle decodrProps = new Bundle();
        decodrProps.putInt(Category.Decoder.CODE128_ENABLE, 0);
        decodrProps.putInt(Category.Decoder.QRCODE_ENABLE, 0);

        decoderConfig.putBundle(IntentKeys.BUNDLE_EXTRA_PARAM_LIST, intentProps);

        categoryList.add(outputConfig);


        bMain.putParcelableArrayList(IntentKeys.BUNDLE_EXTRA_CATEGORY_CONFIG,categoryList);



        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(IntentKeys.ACTION_EXTRA_SET_CONFIG, bMain);
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        this.sendBroadcast(i);
    }

    private void setSingleCategoryForProfile() {
        Bundle bMain = new Bundle();
        bMain.putString(IntentKeys.BUNDLE_EXTRA_PROFILE_NAME,"Profile2");
        bMain.putString(IntentKeys.BUNDLE_EXTRA_PROFILE_ENABLED, "true");
        bMain.putString(IntentKeys.BUNDLE_EXTRA_CONFIG_MODE,IntentKeys.PROFILE_CONFIG_MODE_CREATE_IF_NOT_EXIST);

        ArrayList<Bundle> appList = new ArrayList<>();

        Bundle bundleApp1 = new Bundle();
        bundleApp1.putString(IntentKeys.BUNDLE_EXTRA_PACKAGE_NAME,"com.android.settings");
        bundleApp1.putStringArray(IntentKeys.BUNDLE_EXTRA_ACTIVITY_LIST, new String[]{"*"});
        appList.add(bundleApp1);

        Bundle bundleApp2 = new Bundle();
        bundleApp2.putString(IntentKeys.BUNDLE_EXTRA_PACKAGE_NAME,"com.android.chrome");
        bundleApp2.putStringArray(IntentKeys.BUNDLE_EXTRA_ACTIVITY_LIST, new String[]{
                "com.google.android.apps.chrome.Main",
                "org.chromium.chrome.browser.media.PictureInPictureActivity",
                "org.chromium.chrome.browser.app.reengagement.ReengagementActivity"});
        appList.add(bundleApp2);

        Bundle bundleApp3 = new Bundle();
        bundleApp3.putString(IntentKeys.BUNDLE_EXTRA_PACKAGE_NAME,"com.android.mms");
        bundleApp3.putStringArray(IntentKeys.BUNDLE_EXTRA_ACTIVITY_LIST, new String[]{"com.android.mms.ui.ComposeMessageActivity"});

        appList.add(bundleApp3);



        bMain.putParcelableArrayList(IntentKeys.BUNDLE_EXTRA_ACTIVITY_LIST,appList);

        Intent i = new Intent();
        i.setAction(IntentKeys.API_ACTION);
        i.putExtra(IntentKeys.ACTION_EXTRA_SET_CONFIG, bMain);
        i.putExtra(IntentKeys.ACTION_EXTRA_SEND_RESULT,"true");
        this.sendBroadcast(i);
    }
    private void receiveSetConfigResult(String command, Intent intent) {
        String resultInfo = "";
        String result = intent.getStringExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT);
        if (intent.hasExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT_INFO)) {
            Bundle bundle = intent.getBundleExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT_INFO);
            Set<String> keys = bundle.keySet();
            if(keys != null) {
                for (String key: keys) {
                    if(IntentKeys.BUNDLE_EXTRA_PROFILE_NAME.equals(key)) {
                        resultInfo += key + ": "+bundle.getString(key) + "\n";
                    } else if(IntentKeys.BUNDLE_EXTRA_APP_LIST.equals(key)) {
                        try {
                            ArrayList<Bundle> bundleArrayList  = bundle.getParcelableArrayList(IntentKeys.BUNDLE_EXTRA_APP_LIST);
                            if(bundleArrayList != null) {
                                for(Bundle configBundle:bundleArrayList){
                                    Set<String> keys2 = configBundle.keySet();
                                    for (String key2 : keys2) {
                                        resultInfo += key2+":"+configBundle.getString(key2)+ "\n";
                                    }
                                }
                            }
                        } catch (ClassCastException e){
                            e.fillInStackTrace();
                            resultInfo += key + ": "+bundle.getString(key) + "\n";
                        }
                    } else if(IntentKeys.BUNDLE_EXTRA_CATEGORY_CONFIG.equals(key)) {
                        try {
                            ArrayList<Bundle> bundleArrayList  = bundle.getParcelableArrayList(IntentKeys.BUNDLE_EXTRA_CATEGORY_CONFIG);
                            if(bundleArrayList != null) {
                                for(Bundle configBundle:bundleArrayList){

                                    Set<String> keys2 = configBundle.keySet();
                                    for (String key2 : keys2) {
                                        resultInfo += key2+":"+configBundle.getString(key2)+ "\n";
                                    }
                                }
                            }
                        } catch (ClassCastException e){
                            e.fillInStackTrace();
                            resultInfo += key + ": "+bundle.getString(key) + "\n";
                        }
                    } else {
                        resultInfo += key + ": "+bundle.getString(key) + "\n";
                    }
                }
            }
        }
        String text = "Command: "+command+"\n" +
                "Result: " +result+"\n" +
                "Result Info: " +resultInfo + "\n";
        uriShare.setText(text);
    }
    private void receiveGetConfigResult(String command, Intent intent) {
        String resultInfo = "";
        String result = intent.getStringExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT);
        Bundle b = intent.getExtras();
        Bundle res = b.getBundle(IntentKeys.ACTION_EXTRA_GET_CONFIG);
        if(!res.isEmpty()) {
            String profileName = res.getString(IntentKeys.BUNDLE_EXTRA_PROFILE_NAME);
            resultInfo += "GET_CONFIG profileName: " + profileName + "\n";
            if(res.containsKey(IntentKeys.RESULT_ACTION_LABEL_RESULT_CODE)) {
                resultInfo += "RESULT_CODE : " + res.getString(IntentKeys.RESULT_ACTION_LABEL_RESULT_CODE) + "\n";
            }
            ArrayList<Bundle> appList = res.getParcelableArrayList("APP_LIST");
            if(appList == null) {
                Log.d(TAG,"Profile information is not found for "+profileName);
            } else if(appList.size() == 0){
                resultInfo += "Profile "+profileName+" has no associated apps" + "\n";
            } else {
                resultInfo += "APP_LIST:" + "\n";
                for(Bundle b1 :appList ){
                    resultInfo += b1.getString("PACKAGE_NAME")+":"+b1.getStringArrayList("ACTIVITY_LIST")+ "\n";
                }
            }

            ArrayList<Bundle> bundleArrayList  = res.getParcelableArrayList(IntentKeys.BUNDLE_EXTRA_CATEGORY_CONFIG);
            if(bundleArrayList != null) {
                for(Bundle configBundle:bundleArrayList){
                    resultInfo += "Category Name:" + configBundle.getString(IntentKeys.BUNDLE_EXTRA_CATEGORY_NAME) + "\n";
                    Set<String> keys2 = configBundle.keySet();
                    for (String key2 : keys2) {
                        if (!key2.equalsIgnoreCase(IntentKeys.BUNDLE_EXTRA_PARAM_LIST)) {
                            Log.d(TAG,"configBundle for "+key2);
                        } else {
                            Bundle params = configBundle.getBundle(IntentKeys.BUNDLE_EXTRA_PARAM_LIST);
                            Set<String> keys3 = params.keySet();
                            for (String key3 : keys3) {
                                //TODO consume the params
                                Object object = params.get(key3);
                                if(object instanceof String) {
                                    resultInfo += key3+":"+params.getString(key3)+ "\n";
                                } else {
                                    resultInfo += key3+":"+params.getInt(key3)+ "\n";
                                }
                            }
                        }
                    }
                }
            }
        }
        String text = "Command: "+command+"\n" +
                "Result: " +result+"\n" +
                "Result Info: " +resultInfo + "\n";
        uriShare.setText(text);
    }
    private void receiveImportResult(String command, Intent intent) {
        String resultInfo = "";
        String result = intent.getStringExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT);
        if (intent.hasExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT_INFO)) {
            ArrayList<Bundle> bundleList = intent.getParcelableArrayListExtra(IntentKeys.RESULT_ACTION_EXTRA_RESULT_INFO);
            if(bundleList!= null && !bundleList.isEmpty()){
                for(Bundle resultBundle : bundleList){
                    Set<String> keys = resultBundle.keySet();
                    for (String key : keys) {
                        if(key.equalsIgnoreCase(IntentKeys.RESULT_ACTION_LABEL_RESULT_CODE)){
                            resultInfo += key + ": " + resultBundle.getString(key);
                        }else {
                            resultInfo += key + ": " + resultBundle.getString(key) + "\n";
                        }
                    }
                }
            }
        }

        String text = "Command: "+command+"\n" +
                "Result: " +result+"\n" +
                "Result Info: " +resultInfo + "\n";
        uriShare.setText(text);
    }
    // 请求权限
    public void requestPermissions(int requestCode) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList<String> requestPerssionArr = new ArrayList<>();
                /*int hasCamrea = checkSelfPermission(Manifest.permission.CAMERA);
                if (hasCamrea != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.CAMERA);
                }*/

                int hasSdcardRead = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
                if (hasSdcardRead != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.READ_EXTERNAL_STORAGE);
                }

                int hasSdcardWrite = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (hasSdcardWrite != PackageManager.PERMISSION_GRANTED) {
                    requestPerssionArr.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }
                // 是否应该显示权限请求
                if (requestPerssionArr.size() >= 1) {
                    String[] requestArray = new String[requestPerssionArr.size()];
                    for (int i = 0; i < requestArray.length; i++) {
                        requestArray[i] = requestPerssionArr.get(i);
                    }
                    requestPermissions(requestArray, requestCode);
                } else {
                    copyAssetsToDst(this, "myprofile","myprofile");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        boolean flag = false;
        for (int i = 0; i < permissions.length; i++) {
            if (PackageManager.PERMISSION_GRANTED == grantResults[i]) {
                flag = true;
            }
        }
        copyAssetsToDst(this, "myprofile","myprofile");
    }
    private void copyAssetsToDst(Context context, String srcPath, String dstPath) {
        try {
            String fileNames[] = context.getAssets().list(srcPath);
            if (fileNames.length > 0) {
                File file = new File("sdcard/", dstPath);
                if (!file.exists()) file.mkdirs();
                for (String fileName : fileNames) {
                    if (!srcPath.equals("")) { // assets 文件夹下的目录
                        copyAssetsToDst(context, srcPath + File.separator + fileName, dstPath + File.separator + fileName);
                    } else { // assets 文件夹
                        copyAssetsToDst(context, fileName, dstPath + File.separator + fileName);
                    }
                }
            } else {
                File outFile = new File("sdcard/", dstPath);
                InputStream is = context.getAssets().open(srcPath);
                FileOutputStream fos = new FileOutputStream(outFile);
                byte[] buffer = new byte[1024];
                int byteCount;
                while ((byteCount = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, byteCount);
                }
                fos.flush();
                is.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void copyAssetsToDataDst(Context context, String srcPath, String dstPath) {
        try {
            File outFile = new File(dstPath);
            InputStream is = context.getAssets().open(srcPath);
            FileOutputStream fos = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int byteCount;
            while ((byteCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
            is.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}