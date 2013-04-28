package snippets.bytecode.javassist.dump.a1;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Mnemonic;
import javassist.bytecode.Opcode;
import javassist.tools.Dump;

public class MyDataDumpField {
    public static void main(String[] args) throws IOException, BadBytecode, Exception {
        MyDataDumpField dump = new MyDataDumpField();
        dump.dumpMyDataClass();
    }
    
    private void dumpMyDataClass() throws IOException, BadBytecode, Exception {
        ClassFile cf = new ClassFile(new DataInputStream(getClass().getResourceAsStream("MyData.class")));

        for (Object m : cf.getMethods()) {
            MethodInfo minfo = (MethodInfo)m;
            System.out.println(minfo.getName());
            CodeAttribute ca = minfo.getCodeAttribute();
            for (CodeIterator ci = ca.iterator(); ci.hasNext();) {
                int index = ci.next();
                int op = ci.byteAt(index);
                if (op == Opcode.GETFIELD) {
                    int a1 = ci.s16bitAt(index + 1);
                    String fieldName = " " + cf.getConstPool().getFieldrefName(a1); 
                    System.out.println("field name: " + fieldName);
                }
            }
            System.out.println("====================");
        }
    }
    
    
}
