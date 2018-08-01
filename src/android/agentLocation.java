package org.sample.location;

 import android.content.Context;
 import android.content.Intent;

 import org.apache.cordova.CallbackContext;
 import org.apache.cordova.CordovaPlugin;
 import org.json.JSONArray;
 import org.json.JSONException;

 public class AgentLocation extends CordovaPlugin {
     // public ArrayList itemsList = new ArrayList();
     public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
         try {
             if (action.equals("addLocation")) {
                //  String item = args.getString(0);
                //  String className = args.getString(1);
                //  Context context = cordova.getActivity().getApplicationContext();
                //  Intent intent = new Intent(context,Class.forName(className));
                //  itemsList.add(item);
                //  intent.putStringArrayListExtra("items", itemsList);
                //  cordova.startActivityForResult(this,intent,1);
                ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                 callbackContext.success();
                 return true;
             } else {
             callbackContext.error("Invalid action");
             return false;
             }
         } catch(Exception e) {
             System.err.println("Exception: " + e.getMessage());
             callbackContext.error(e.getMessage());
             return false;
         }
     }
       public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startService(new Intent(this, MyService.class));

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
    //  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    //      // Handle a result here if one set in the Activity class started
    //      System.out.println("Activity Result: " + resultCode); //-1 is RESULT_OK
    //      if (resultCode==Activity.RESULT_OK) {
    //          System.out.println("All good!");
    //      }
    //  }     
 }