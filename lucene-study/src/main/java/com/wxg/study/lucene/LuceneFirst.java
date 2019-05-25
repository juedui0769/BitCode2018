package com.wxg.study.lucene;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * form B站 : https://www.bilibili.com/video/av48091319/?p=11
 *
 * 索引的内容是"Magic Tree House"第一课
 *
 * create at 2019年5月26日00:08:31
 */
public class LuceneFirst {

    private static final String INDEX_STORE_PATH = "D:\\wxg_test\\03_lucene\\01_index";

    private Directory indexStoreDir;

    public LuceneFirst() {
        try {
            indexStoreDir = FSDirectory.open(new File(INDEX_STORE_PATH).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@link RAMDirectory} 内存中
     * {@link org.apache.lucene.store.FSDirectory} 磁盘上
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void createIndex() throws Exception {
        String sourceStorePath = "D:\\wxg_test\\03_lucene\\02_magictreehouse";

        IndexWriter indexWriter = new IndexWriter(indexStoreDir, new IndexWriterConfig());
        File sourceDir = new File(sourceStorePath);
        File[] files = sourceDir.listFiles();

        try {
            for (File f : files) {
                String fName = f.getName();
                String fPath = f.getPath();
                String fContent = FileUtils.readFileToString(f, StandardCharsets.UTF_8);
                long fileSize = FileUtils.sizeOf(f);

                // Field
                Field fieldName = new TextField("name", fName, Field.Store.YES);
                Field fieldPath = new TextField("path", fPath, Field.Store.YES);
                Field fieldContent = new TextField("content", fContent, Field.Store.YES);
                Field fieldSize = new TextField("size", fileSize+"", Field.Store.YES);

                // Document
                Document document = new Document();
                document.add(fieldName);
                document.add(fieldPath);
                document.add(fieldContent);
                document.add(fieldSize);

                //
                indexWriter.addDocument(document);
            }
        } finally {
            indexWriter.close();
        }
    }

    @Test
    public void searchIndex() throws Exception {
        IndexReader indexReader = DirectoryReader.open(indexStoreDir);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        // 必须是小写的
        Query query = new TermQuery(new Term("content", "dinosaur"));
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("查询总记录数 : " + topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc doc : scoreDocs) {
            int docId = doc.doc;
            Document doc1 = indexSearcher.doc(docId);
            System.out.println(doc1.get("name"));
            System.out.println(doc1.get("path"));
            System.out.println(doc1.get("size"));
//            System.out.println(doc1.get("content"));
            System.out.println("==================");
        }
        indexReader.close();
    }

}
