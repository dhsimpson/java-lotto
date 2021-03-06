package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class LottoGenerator {
    private static final int VALUE_LEFT_BOUND = 1;
    private static final int VALUE_RIHGT_BOUND = 46;

    private static final int COUNT_LEFT_BOUND = 0;
    private static final int COUNT_RIGHT_BOUND = 5;

    private static final int BONUS_IDX = 6;

    private static List<LottoNumber> candidateNumbers = new ArrayList<>();

    static {
        for (int i = VALUE_LEFT_BOUND; i < VALUE_RIHGT_BOUND; i++) {
            candidateNumbers.add(
                new LottoNumber(i)
            );
        }
    }

    // for lotto machine (bonus number)
    public static LottoTicket generateLotto(LottoNumber bonus) {
        Collections.shuffle(candidateNumbers);

        List<LottoNumber> selectedNumbers = candidateNumbers.subList(
            COUNT_LEFT_BOUND, COUNT_RIGHT_BOUND + 1
        );
        Collections.sort(selectedNumbers);

        return new LottoTicket(selectedNumbers, bonus);
    }

    // overload for buyer
    public static LottoTicket generateLotto(int j) {
        List<LottoNumber> candidateNumbers2 = new ArrayList<>();
        for (int i = VALUE_LEFT_BOUND; i < VALUE_RIHGT_BOUND; i++) {
            candidateNumbers2.add(
                new LottoNumber(i)
            );
        }

        Collections.shuffle(candidateNumbers2, new Random(j));

        List<LottoNumber> selectedNumbers = candidateNumbers2.subList(
                COUNT_LEFT_BOUND, COUNT_RIGHT_BOUND + 1
        );
        Collections.sort(selectedNumbers);

        return new LottoTicket(selectedNumbers);
    }

    public static LottoNumber generateBonus() {
        return candidateNumbers.get(BONUS_IDX);
    }
}
