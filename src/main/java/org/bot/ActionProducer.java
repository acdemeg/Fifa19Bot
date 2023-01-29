package org.bot;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.IntConsumer;

import static org.bot.GameAction.CONTROLS_ENUM_KEY_CODE_MAP;
import static org.bot.Main.ROBOT;

/**
 * This class take responsible for events generation.
 * Now is available only keyboard actions
 */
@Data
@RequiredArgsConstructor
public class ActionProducer {

    private final GameAction gameAction;

    public void makeGameAction() {
        handleControls(ROBOT::keyPress, true);
        handleControls(ROBOT::keyRelease, false);
    }

    private void handleControls(IntConsumer keyAction, boolean needDelay) {
        gameAction.getControls().forEach(control -> {
            List<Integer> keyEvents = CONTROLS_ENUM_KEY_CODE_MAP.get(control);
            keyEvents.forEach(keyAction::accept);
            if (needDelay) {
                ROBOT.delay(control.getDelay().get());
            }
        });
    }
}