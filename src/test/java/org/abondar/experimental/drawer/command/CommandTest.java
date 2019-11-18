package org.abondar.experimental.drawer.command;

import org.abondar.experimental.drawer.exception.InvalidCommandException;
import org.abondar.experimental.drawer.util.CommandUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandTest {

    private CommandSwitcher switcher = new CommandSwitcher();

    @Test
    public void createCommandTest() throws InvalidCommandException {
       switcher.executeCommand(new String[]{CommandUtil.CREATE_OR_CLEAR,"20","4"});

       assertNotNull(switcher.getCanvas());
    }

    @Test
    public void clearCanvasTest() throws InvalidCommandException{
        switcher.executeCommand(new String[]{CommandUtil.CREATE_OR_CLEAR,"20","4"});
        switcher.executeCommand(new String[]{CommandUtil.LINE,"1","2","6","2"});
        switcher.executeCommand(new String[]{CommandUtil.CREATE_OR_CLEAR});
    }



    @Test
    public void createCommandWrongParamTest()  {
        assertThrows(InvalidCommandException.class,()->
                switcher.executeCommand(new String[]{CommandUtil.CREATE_OR_CLEAR,"20"}));
    }

    @Test
    public void lineCommandTest() throws InvalidCommandException {
        switcher.executeCommand(new String[]{CommandUtil.CREATE_OR_CLEAR,"20","4"});
        switcher.executeCommand(new String[]{CommandUtil.LINE,"1","2","6","2"});

    }

    @Test
    public void lineCommandEmptyCanvasTest() {
        assertThrows(InvalidCommandException.class,()->
        switcher.executeCommand(new String[]{CommandUtil.LINE,"1","2","6","2"}));
    }

    @Test
    public void lineCommandCanvasExceptionTest() throws InvalidCommandException  {
        switcher.executeCommand(new String[]{CommandUtil.CREATE_OR_CLEAR,"20","4"});
        assertThrows(InvalidCommandException.class,()->
                switcher.executeCommand(new String[]{CommandUtil.LINE,"1","2","6","3"}));
    }

    @Test
    public void rectangleCommandTest() throws  InvalidCommandException{
        switcher.executeCommand(new String[]{CommandUtil.CREATE_OR_CLEAR,"20","4"});
        switcher.executeCommand(new String[]{CommandUtil.RECTANGLE,"16","1","20","3"});
    }

    @Test
    void bucketCommandTest() throws InvalidCommandException{
        switcher.executeCommand(new String[]{CommandUtil.CREATE_OR_CLEAR,"20","4"});
        switcher.executeCommand(new String[]{CommandUtil.BUCKET_FILL,"16","1","1"});
    }

    @Test
    void bucketCommandWrongLastParamTest() {
        assertThrows(InvalidCommandException.class,()->
                switcher.executeCommand(new String[]{CommandUtil.BUCKET_FILL,"16","1","1234"}));
    }

    @Test
    void wrongCommandTest(){
        assertThrows(InvalidCommandException.class,()->
                switcher.executeCommand(new String[]{"bla bla"}));

    }
}
