package com.brr.newcodingtest.n20006;

import java.io.*;
import java.util.*;

class Player {
    int level;
    String name;

    public Player(int level, String name) {
        this.level = level;
        this.name = name;
    }
}

class Game {
    int gameLevel;
    List<Player> players;

    public Game(int gameLevel, List<Player> players) {
        this.gameLevel = gameLevel;
        this.players = players;
    }
}

public class Main {
    static List<Game> games = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (games.isEmpty()) {
                makeNewGame(level, name);
            } else {
                boolean check = true;
                for (int j = 0; j < games.size(); j++) {
                    int gameLevel = games.get(j).gameLevel;

                    if (games.get(j).players.size() == m) continue;

                    if (gameLevel - 10 <= level && gameLevel + 10 >= level) {
                        games.get(j).players.add(new Player(level, name));
                        check = false;
                        break;
                    }
                }
                if (check) {
                    makeNewGame(level, name);
                }

            }

        }

        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            game.players.sort((a, b) -> a.name.compareTo(b.name));
            if (game.players.size() == m) {
                sb.append("Started!").append("\n");
                for (int k = 0; k < m; k++) {
                    sb.append(game.players.get(k).level).append(" ").append(game.players.get(k).name).append("\n");
                }
            } else {
                sb.append("Waiting!").append("\n");
                for (int k = 0; k < game.players.size(); k++) {
                    sb.append(game.players.get(k).level).append(" ").append(game.players.get(k).name).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    static void makeNewGame(int level, String name) {
        Player player = new Player(level, name);
        List<Player> players = new ArrayList<>();
        players.add(player);
        games.add(new Game(level, players));
    }
}
