package cn.edu.gdmec.android.mobileguard.m8trafficmonitor.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import cn.edu.gdmec.android.mobileguard.m8trafficmonitor.service.TrafficMonitoringService;
import cn.edu.gdmec.android.mobileguard.m8trafficmonitor.utils.SystemInfoUtils;

/**
 * Created by student on 17/10/17.
 */

public class BootCompleteReciever extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent){
        if(!SystemInfoUtils.isServiceRunning(context,
                "cn.edu.gdmec.android.mobileguard.m8trafficmonitor.service.TrafficMonitoringService")){
            Log.d("traffic service","turn on");
            context.startService(new Intent(context, TrafficMonitoringService.class));
        }
    }
}
