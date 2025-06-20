package io.kyle.javaguard.transform;

import io.kyle.javaguard.bean.TransformInfo;
import io.kyle.javaguard.exception.TransformException;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author kyle kyle_derrick@foxmail.com
 * 2024/9/30 16:41
 */
public interface Transformer {
    TransformerCreator JAR_TRANSFORMER = JarTransformer::new;
    TransformerCreator[] TRANSFORMERS = {
            ClassTransformer::new,
            JAR_TRANSFORMER,
            DefaultTransformer::new,
    };

    boolean isSupport(String name);
    boolean encrypt(final InputStream in, final OutputStream out) throws TransformException;
    boolean decrypt(final InputStream in, final OutputStream out) throws TransformException;

    interface TransformerCreator {
        Transformer create(TransformInfo transformInfo);
    }
}
