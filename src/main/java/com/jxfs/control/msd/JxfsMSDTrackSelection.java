package com.jxfs.control.msd;

import com.jxfs.general.JxfsType;

public class JxfsMSDTrackSelection extends JxfsMSDTracks {

    // Methods
    public void setTrack1() {
        track1 = true;
    }

    public void setTrack2() {
        track2 = true;
    }

    public void setTrack3() {
        track3 = true;
    }

    public void setAllTracks() {
        track1 = true;
        track2 = true;
        track3 = true;
    }

    public void setNoTracks() {
        track1 = false;
        track2 = false;
        track3 = false;
    }

    // Constructor
    public JxfsMSDTrackSelection(boolean track1, boolean track2, boolean track3) {
        super(track1, track2, track3);
    }
}