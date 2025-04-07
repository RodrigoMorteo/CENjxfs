package com.jxfs.control.scn;

import com.jxfs.events.JxfsException;
import com.jxfs.general.IJxfsConst;
import com.jxfs.general.JxfsType;

/*
* Abstract basic class of the data returned by the: 
JxfsOperationCompleteEvent event for scan(), process() and processBundle() operations and the values of the JxfsScnQueryDataResult.dataInformation map returned in the JxfsOperationCompleteEvent event for queryData()
*/
public abstract class JxfsScnResult extends JxfsType implements IJxfsConst{

    /**
     * Specifies the position where the media is stored after scanning or processing.
     */
    private JxfsScnResultStoredPositionEnum storedPosition;

    /**
     * Specifies the pocket where the media is stored after scanning or processing.
     * This property will be null if storedPosition property is different from 'pocket'.
     */
    private JxfsScnPocketStatus pocket;

    /**
     * Specifies the results of the process operations ( encoding, endorsing, stamping).
     * It will be null if  JxfsScnCapabilities.additionalProcessingSupported is notSupported.
     */
    private JxfsScnProcessOperationsResult processOperationsResult;

    /**
     * This property will stand for JXFS_RC_SUCESSFUL if there's no additional
     * information to be returned (i.e. item was properly scanned/processed). In any other
     * case gives further information about the result of the operation. It can take one
     * of the values defined at the error codes section.
     */
    private int resultDetail;

    /**
     * Constructor of the JxfsScnResult class.
     *
     * @param storedPosition           Specifies the position where the media is stored after scanning or processing.
     * @param pocket                  Specifies the pocket where the media is stored after scanning or processing.
     * @param processOperationsResult Specifies the results of the process operations.
     * @param resultDetail            Provides further information about the result of the operation.
     * @throws JxfsException If any of the parameters are invalid.
     */
    public JxfsScnResult(JxfsScnResultStoredPositionEnum storedPosition,
                         JxfsScnPocketStatus pocket,
                         JxfsScnProcessOperationsResult processOperationsResult,
                         int resultDetail) throws JxfsException {
        if (storedPosition == null) {
            throw new JxfsException(JXFS_E_PARAMETER_INVALID, "storedPosition cannot be null");
        }

        if (pocket == null && storedPosition != JxfsScnResultStoredPositionEnum.POCKET) {
            throw new JxfsException(JXFS_E_PARAMETER_INVALID, "pocket cannot be null if storedPosition is not pocket");
        }

        // Validate resultDetail against defined error codes (source does not provide error code definitions)

        this.storedPosition = storedPosition;
        this.pocket = pocket;
        this.processOperationsResult = processOperationsResult;
        this.resultDetail = resultDetail;
    }

    // Getters for the properties
    public JxfsScnResultStoredPositionEnum getStoredPosition() {
        return storedPosition;
    }

    public JxfsScnPocketStatus getPocket() {
        return pocket;
    }

    public JxfsScnProcessOperationsResult getProcessOperationsResult() {
        return processOperationsResult;
    }

    public int getResultDetail() {
        return resultDetail;
    }
}