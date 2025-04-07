/*
* To make an application ready for receiving events of a specific type, it must implement the
* corresponding listener interface by defining the included listener method.
* All events have applicable event data attached to them and can be explicitly requested by
* the application by using the addXXXListener Methods in the Device Control classes
* (where XXX depicts the EventType). An application registering for 2 event types would
* look like this (the try-catch expressions are not included):
*/

/*package SampleApp;

import com.jxfs.events.JxfsOperationCompleteEvent;
import com.jxfs.events.JxfsStatusEvent;

public class JxfsSampleListener implements IJxfsStatusListener, IJxfsOperationCompleteListener
{
    public JxfsSampleListener()
    {
        JxfsDeviceManager mgr=JxfsDeviceManager.getReference();
        JxfsMagStripe mag=mgr.getDevice(“myMagStripe”);
        mag.addOperationCompleteListener((IJxfsOperationCompleteListener)this);
        mag.addStatusListener((IJxfsStatusListener)this);
        ...
    }
    public void operationCompleteOccurred(JxfsOperationCompleteEvent e)
    {
        if(e.getResult()==IJxfsConst.JXFS_RC_SUCCESSFUL)
        {
            //Your code Here...
        }
        //Other code here...
    }
    public void statusOccurred(JxfsStatusEvent e)
    {
        //YOur Code here   ...
    }
}
*/