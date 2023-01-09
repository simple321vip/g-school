package cn.violin.school.spring.asm.ext;

import org.springframework.asm.ClassVisitor;
import org.springframework.asm.FieldVisitor;
import org.springframework.asm.MethodVisitor;
import org.springframework.asm.Opcodes;

public class ViolinClassVisitor extends ClassVisitor {

    public ViolinClassVisitor() {
        super(Opcodes.ASM9);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(name + ":" + superName);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println(name);
        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println(name);
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }
}
