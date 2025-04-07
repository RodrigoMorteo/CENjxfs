package com.jxfs.control.msd;

import com.jxfs.general.JxfsType;

/**The JxfsMSDTracks class plays a crucial role in the J/XFS framework for managing MSD devices.
 * It serves as the foundation for representing the selection status of magnetic stripe tracks.
 * This information is vital for operations such as reading data from specific tracks or writing data to them.
*/
public class JxfsMSDTracks extends JxfsType {

    // Properties
    protected boolean track1;
    protected boolean track2;
    protected boolean track3;

    // Methods
    public boolean isTrack1() {
        return track1;
    }

    public boolean isTrack2() {
        return track2;
    }

    public boolean isTrack3() {
        return track3;
    }

    public boolean allTracks() {
        return track1 && track2 && track3;
    }

    public boolean noTracks() {
        return !track1 && !track2 && !track3;
    }

    // Constructor
    public JxfsMSDTracks(boolean track1, boolean track2, boolean track3) {
        this.track1 = track1;
        this.track2 = track2;
        this.track3 = track3;
    }
}
