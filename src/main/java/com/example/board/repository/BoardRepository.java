package com.example.board.repository;

import com.example.board.model.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {

    private static long count = 1L;
    private static final Map<Long, Board> dataBase = new HashMap<>();
    private static long basicUserIdx = 20100337L;
    private static String basicNickName = "뉴진스";

    // Create
    public Board saveToDB(Board board) {
        board.setContentNumber(count++);
        dataBase.put(board.getContentNumber(), board);
        return board;
    }

    // Read 1
    public Board findContentByContentNumber(Long contentNumber) {
        return dataBase.get(contentNumber);
    }

    // Read All
    public List<Board> viewAll() {
        return new ArrayList<>(dataBase.values());
    }

    // Update
    public void updateContent(Long contentNumber, Board board) {
        Board oneContent = findContentByContentNumber(contentNumber);
        oneContent.setContent(board.getContent());
        oneContent.setTitle(board.getTitle());
        oneContent.setNickName(board.getNickName());
    }

    // Delete
    public void deleteContent(Long contentNumber) {
        dataBase.remove(contentNumber);
    }

    public String getBasicNickName() {
        return basicNickName;
    }
    public Long getBasicUserIdx() {
        return basicUserIdx;
    }

    public void updateBasicNickName(Board board) {
        basicNickName = board.getNickName();
    }
    public void updateBasicUserIdx() {
        basicUserIdx++;
    }
}
