package demo.player;

/**
 * Created by BinhBT on 4/14/2016.
 */
import android.view.View;

import com.google.android.exoplayer.ExoPlayer;


/**
 * @author BinhBT
 * An implementation of {@link MediaPlayerControl} for controlling an {@link ExoPlayer} instance.
 * <p>
 * This class is provided for convenience, however it is expected that most applications will
 * implement their own player controls and therefore not require this class.
 * Re implement to {@link demo.player.VideoControllerView.MediaPlayerControl} to custome UI for player
 */
public class PlayerControl implements VideoControllerView.MediaPlayerControl {

    private final ExoPlayer exoPlayer;

    public PlayerControl(ExoPlayer exoPlayer) {
        this.exoPlayer = exoPlayer;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    /**
     * This is an unsupported operation.
     * <p>
     * Application of audio effects is dependent on the audio renderer used. When using
     * {@link com.google.android.exoplayer.MediaCodecAudioTrackRenderer}, the recommended approach is
     * to extend the class and override
     * {@link com.google.android.exoplayer.MediaCodecAudioTrackRenderer#onAudioSessionId}.
     *
     * @throws UnsupportedOperationException Always thrown.
     */
   // @Override
    public int getAudioSessionId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBufferPercentage() {
        return exoPlayer.getBufferedPercentage();
    }

    @Override
    public long getCurrentPosition() {
        return exoPlayer.getDuration() == ExoPlayer.UNKNOWN_TIME ? 0
                : (int) exoPlayer.getCurrentPosition();
    }

    @Override
    public long getDuration() {
        return exoPlayer.getDuration() == ExoPlayer.UNKNOWN_TIME ? 0
                : (int) exoPlayer.getDuration();
    }

    @Override
    public boolean isPlaying() {
        return exoPlayer.getPlayWhenReady();
    }

    @Override
    public void start() {
        exoPlayer.setPlayWhenReady(true);
    }

    @Override
    public void pause() {
        exoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void seekTo(long timeMillis) {
        long seekPosition = exoPlayer.getDuration() == ExoPlayer.UNKNOWN_TIME ? 0
                : Math.min(Math.max(0, timeMillis), getDuration());
        exoPlayer.seekTo(seekPosition);
    }
    @Override
    public boolean isFullScreen()
    {
        //@TODO Not implement
        return false;
    }
    @Override
    public void  toggleFullScreen(){
        //@TODO Not implement
    }
    @Override
    public void onSettingClick(View v){
        //@TODO not implement
    }
}
