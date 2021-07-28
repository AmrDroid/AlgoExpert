package AlgoExpert.Easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TournamentWinner {


    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        HashMap<String, Integer> points = new HashMap<>();
        String winner = "";
        points.put(winner, 0);

        for (int i = 0; i < competitions.size(); i++) {
            String currentWinner = results.get(i) == 0 ? competitions.get(i).get(1) : competitions.get(i).get(0);

            points.put(currentWinner, points.getOrDefault(currentWinner, 0) + 3);

            if (points.get(winner) <= points.get(currentWinner)) winner = currentWinner;
        }

        return winner;
    }

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, int[] results) {
        final int HOME_TEAM_WON = 1;

        HashMap scores = new HashMap<String, Integer>();

        for (int idx = 0; idx < competitions.size(); idx++) {
            ArrayList<String> pair = competitions.get(idx);
            int result = results[idx];
            String winningTeam = result == HOME_TEAM_WON ? pair.get(0) : pair.get(1);
            int currentScore = Integer.parseInt(scores.getOrDefault(winningTeam, 0).toString());
            scores.put(winningTeam, currentScore + 3);
        }

        int currentBestScore = 0;
        String currentBestTeam = "";

        Set<String> set = scores.keySet();
        for (String str : set) {
            int score = (int) scores.get(str);
            if (score > currentBestScore) {
                currentBestScore = score;
                currentBestTeam = str;
            }
        }

        return currentBestTeam;
    }


}
