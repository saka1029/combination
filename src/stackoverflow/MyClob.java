package stackoverflow;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.sql.Clob;

    public class MyClob implements java.sql.Clob {
        final String value;
        public MyClob(String value) { this.value = value; }
        @Override public long length() { return value.length(); }
        @Override public String getSubString(long pos, int length) {
            return value.substring((int)pos, (int)pos + length);
        }
        @Override public Reader getCharacterStream() { return new StringReader(value); }
        @Override public InputStream getAsciiStream() { return null; } 
        @Override public long position(String searchstr, long start) { return 0; }
        @Override public long position(Clob searchstr, long start) { return 0; }
        @Override public int setString(long pos, String str) { return 0; } 
        @Override public int setString(long pos, String str, int offset, int len) { return 0; } 
        @Override public OutputStream setAsciiStream(long pos) { return null; } 
        @Override public Writer setCharacterStream(long pos) { return null; } 
        @Override public void truncate(long len) { } 
        @Override public void free() { } 
        @Override public Reader getCharacterStream(long pos, long length) { return null; }

    }
