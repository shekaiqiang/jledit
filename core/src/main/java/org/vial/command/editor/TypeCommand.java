/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vial.command.editor;


import org.vial.editor.ConsoleEditor;

public class TypeCommand extends AbstractUndoableCommand {

    private final String str;

    public TypeCommand(ConsoleEditor editor, String str) {
        super(editor);
        this.str = str;
    }

    @Override
    public void execute() {
        editor.put(str);
        editor.setDirty(true);
        editor.flush();
        super.execute();

    }

    @Override
    public void undo() {
        super.undo();
        for (int i = 0; i < str.length(); i++) {
            editor.backspace();
        }
        editor.flush();
    }
}
