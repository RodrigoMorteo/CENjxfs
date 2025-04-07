package com.jxfs.control.scn;
/*
* Contains method and property declarations required by all Scanner device controls.
* The J/XFS General Scanner Device Control interface is defined in IJxfsScnCommonControl and
* IJxfsBaseControl. The intent of the J/XFS General Scanner Device Control is to allow data and control to
* pass between the application and the device support code so that the associated device can be accessed.
* This interface inherits all the logic for a generic J/XFS Device Control and also adds functionality to
* perform scanning and special processing of media. Additional interfaces should be attached to this generic
* interface in order to provide methods for defining scanning parameters depending on the physical device
* type. The provided Device Control classes implement this generic scanner device interface plus specific
* device type interfaces.
*/

import com.jxfs.events.JxfsException;
import com.jxfs.general.JxfsId;
import com.jxfs.control.IJxfsBaseControl;

public interface IJxfsScnCommonControl extends IJxfsBaseControl   //TODO: Validate change of spec class for interface
{
	//TODO: Review modifiers for all property 
    public static final JxfsScnCapabilities capabilities = new JxfsScnCapabilities();
    public static final JxfsScnAutoFeedOnEnum autoFeedOn = new JxfsScnAutoFeedOnEnum();
    public static final JxfsScnStatus scnStatus = new JxfsScnStatus();
    public static final int refusePocketId = 0;

    /*
    * Check if all the chars of the endorseText are supported chars in the endorse process. If return value is trueall the chars of the endorseText are supported for the endorse process.
    * Exceptions:
    *   JXFS_E_PARAMETER_INVALID if endorseText is a null reference.
    *   JXFS_E_NOT_SUPPORTED if IJxfsScnCommonControl.capabilities.endorserCapabilities.endorserSupported equals ‘notSupported’ or ‘unknown’.
    */
    boolean isEndorsable( String endorseText ) throws JxfsException;

    /*
    * This method launches an acquiring process.
    * If IJxfsScnCommonControl.capabilities.scanProgressSupported capability\ equals supported, after the identificationID is returned a series of Intermediate Events will be generated indicating the status of the acquisition process. When the acquisition process completes, a JxfsOperationCompleteEvent event is generated to inform the application of the results and to return the acquired data.
    * The class of the returned data object depends on the device control used.
    * If IJxfsScnCommonControl.autoFeedOn property equals enabled, the JxfsOperationCompleteEvent does not return the acquired data. Instead the application is responsible for retrieving the information. For a detailed description of the retrieval procedure see chapter 4.3
    * If JxfsScnCapabilities.escrowSupported is notSupported, after the scanning, the media will be transported to the specified pocket. On the other hand, if JxfsScnCapabilities.escrowSupported is supported the media will be placed in the escrow (if pocket equals JXFS_C_SCN_ESCROW) or to the specified pocket (if pocket stands for a valid pocket id). If the media can’t be placed in the specified pocket, it will be returned to the reject position. If the reject position is not supported or inoperative it will be returned to the output position. If shutterCmd property in capabilities is required then:
    * - If the input is a tray, the application has to ensure the items are on the tray and the shutter closed before calling scan() J/XFS operation.
    * - If the input is a slot, the application must open the shutter and call the scan() J/XFS operation right after the shutter opened to start item acceptance.
    * - When scan completes, the refused items (if any) are not accessible to the customer and the application has to call shutterMove to open/close shutters for the input and refuse positions.
    * If items remain in the input and refuse position it is the preferred way to clear the input position first and afterwards the refuse position.
    * Parameter:
    *   int ppocket: Specifies the destination pocket, from the available pockets indicated by the IJxfsScnCommonControl.capabilities.pocketsId property. If no pockets are supported (IJxfsScnCommonControl.capabilities.pocketsSupported) JXFS_C_SCN_VALUE_NOT_INITIALIZED constant must be used.
    * Events:
    *   -JxfsOperationCompleteEvent When the acquiring process is completed, this JxfsOperationCompleteEvent is sent to all registered listeners with following data:
    *       Field               Value
    *       operationID         JXFS_O_SCN_SCAN
    *       identificationID    identificationID returned by method.
    *       Result              Common error code or one of the codes listed in Error Codes.
    *       data                if autoFeed is not being used a JxfsType compatible object is returned when the operation completes successfully, otherwise, null is returned. Refer to The Acquiring Process and AutoFeed Capability sections for more information on the type of object returned.
    *   -JxfsIntermediateEvent sent by Scanner Device Control to all registered Intermediate Listeners.
    *   -JxfsStatusEvent sent by Scanner Device Control to all registered Status Listeners. 
    */
    JxfsId scan( int pocket) throws JxfsException; 

    /*
    * 5.4.3.3 process
    */
    JxfsId process( JxfsScnProcessData processData, boolean retrieveFromEscrow) throws JxfsException;

    /*
    * 5.4.3.4 processBundle 
    */
    JxfsId processBundle( java.util.List processDataList, boolean retrieveFromEscrow) throws JxfsException;

    /*
    * 5.4.3.5
    */
    JxfsScnQueryDataResult queryData(int[] dataIds) throws JxfsException;

    /*
    *5.4.3.6 reset 
    */
    JxfsId reset() throws JxfsException;

    /**5.4.3.7 */
    JxfsId rollback() throws JxfsException;

    /**5.4.3.8 */
    JxfsId shutterMove(int position, boolean open) throws JxfsException;


    /**5.4.3.9 */
    JxfsId retract( JxfsScnRetractArea retractArea) throws JxfsException;

    /**5.4.3.10 */
    void resetPocketCount (int pocket) throws JxfsException;
}