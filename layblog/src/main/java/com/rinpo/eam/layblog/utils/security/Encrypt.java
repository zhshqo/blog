package com.rinpo.eam.layblog.utils.security;

import com.rinpo.eam.layblog.utils.security.base64.Base32;
import com.rinpo.eam.layblog.utils.security.base64.Base64;
import com.rinpo.eam.layblog.utils.security.factory.DigestFactory;
import com.rinpo.eam.layblog.utils.security.factory.HexFactory;
import com.rinpo.eam.layblog.utils.security.factory.UrlFactory;

/**
 * 对称和非对称加密请使用SecurityUtils或者单独的AsymmetricEncryption和SymmetricEncryption
 */
public interface Encrypt {

    /**
     * 摘要加密
     */
    DigestFactory digest = new DigestFactory();

    /**
     * hex
     */
    HexFactory hex = new HexFactory();


    /**
     * Base64的编码和解码方案
     */
    Base64 base64 = new Base64();

    /**
     * 提供Base32的编码和解码
     */
    Base32 base32 = new Base32();

    /**
     * url编码解码
     */
    UrlFactory url = new UrlFactory();

}