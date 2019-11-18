package org.abondar.experimental.drawer.command;


import org.abondar.experimental.drawer.draw.Canvas;
import org.abondar.experimental.drawer.exception.InvalidCommandException;
import org.abondar.experimental.drawer.util.CommandUtil;
import org.abondar.experimental.drawer.util.MessageUtil;

import java.util.Arrays;

/**
 * Class for command execution;
 *
 * @author a.bondar
 */
public class CommandSwitcher {

    private CommandExecutor executor;
    private Canvas canvas;

    public CommandSwitcher(){
        this.executor = new CommandExecutor();
    }

    public void executeCommand(String[] params) throws InvalidCommandException {
        switch (params[0]){

            case CommandUtil.CREATE_OR_CLEAR:

                if (params.length==1){
                    if (canvas==null){
                        throw new InvalidCommandException(MessageUtil.CANVAS_NOT_CREATED);
                    }

                    var clear = new ClearCommand(canvas);
                    executor.storeAndExecute(clear);

                } else if (params.length == 3) {
                    var create = new CreateCommand(params[1],params[2]);
                    executor.storeAndExecute(create);
                    canvas = Canvas.getInstance();
                } else {
                        throw new InvalidCommandException(MessageUtil.INVALID_INPIT);
                }
                break;

            case CommandUtil.LINE:
                if (params.length!=5){
                    throw new InvalidCommandException(MessageUtil.INVALID_INPIT);
                }

                if (canvas==null){
                    throw new InvalidCommandException(MessageUtil.CANVAS_NOT_CREATED);
                }

                var line = new DrawCommand(canvas,Arrays.copyOfRange(params,1,params.length),true);
                executor.storeAndExecute(line);
                break;

            case CommandUtil.RECTANGLE:
                if (params.length!=5){
                    throw new InvalidCommandException(MessageUtil.INVALID_INPIT);
                }

                if (canvas==null){
                    throw new InvalidCommandException(MessageUtil.CANVAS_NOT_CREATED);
                }

                var rectangle = new DrawCommand(canvas,Arrays.copyOfRange(params,1,params.length),false);
                executor.storeAndExecute(rectangle);
                break;

            case CommandUtil.BUCKET_FILL:
                if (params.length!=4){
                    throw new InvalidCommandException(MessageUtil.INVALID_INPIT);
                }

                if (params[3].length()>1){
                    throw new InvalidCommandException(MessageUtil.INVALID_INPIT);
                }

                if (canvas==null){
                    throw new InvalidCommandException(MessageUtil.CANVAS_NOT_CREATED);
                }

                var bucket = new BucketFillCommand(canvas,Arrays.copyOfRange(params,1,params.length));
                executor.storeAndExecute(bucket);
                break;

            case CommandUtil.QUIT:
                var quit = new QuitCommand();
                executor.storeAndExecute(quit);
                break;

            default:
                throw new InvalidCommandException(String.format(MessageUtil.UNKNOWN_COMMAND,params[0]));
        }
    }

    public Canvas getCanvas(){
        return canvas;
    }
}
