package tech.acodesigner.dao;

import tech.acodesigner.po.MusicPo;
import tech.acodesigner.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class MusicDao {

    public static MusicPo getMusic(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getCon();
        String sql = "SELECT * FROM blog_music WHERE musicId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        MusicPo music = new MusicPo();
        if (rs.next()) {
            music.setMusicId(rs.getInt("musicId"));
            music.setMusicName(rs.getString("musicName"));
            music.setUrl(rs.getString("url"));
        }
        DBUtil.closeCon(conn);
        return music;
    }

    public static ArrayList<MusicPo> getAllMusics() throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getCon();
        ArrayList<MusicPo> musics = new ArrayList<MusicPo>();
        String sql = "SELECT * FROM blog_music";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            MusicPo music = new MusicPo();
            music.setMusicId(rs.getInt("musicId"));
            music.setMusicName(rs.getString("musicName"));
            music.setUrl(rs.getString("url"));
            musics.add(music);
        }
        DBUtil.closeCon(conn);
        return musics;
    }

    public static void saveMusic(MusicPo music) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getCon();
        String sql = "INSERT INTO blog_music VALUES (null,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, music.getMusicName());
        pstmt.setString(2, music.getUrl());
        pstmt.executeUpdate();
        DBUtil.closeCon(conn);
    }

   /* public static void saveMusic(MusicPo music) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getCon();
        String sql = "INSERT INTO blog_music VALUES (null,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, music.getMusicName());
        pstmt.setString(2, music.getUrl());
        pstmt.executeUpdate();
        DBUtil.closeCon(conn);
    }
   */

    public static void updateMusic(MusicPo music) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getCon();
        String sql = "UPDATE blog_music SET musicName=?,url=? WHERE musicId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, music.getMusicName());
        pstmt.setString(2, music.getUrl());
        pstmt.setInt(3, music.getMusicId());
        pstmt.executeUpdate();
        DBUtil.closeCon(conn);
    }

    public static void deleteMusic(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getCon();
        String sql = "DELETE FROM blog_music where musicId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
