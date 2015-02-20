package br.com.kayala.webquarium.core.infrastructure.analyzer;

import java.io.Reader;
import org.apache.commons.codec.language.RefinedSoundex;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilter;
import org.apache.lucene.analysis.phonetic.PhoneticFilter;
import org.apache.lucene.analysis.snowball.SnowballFilter;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.tartarus.snowball.ext.PortugueseStemmer;

/**
 *
 * @author kayala
 */
public class PortugueseAnalyzer extends Analyzer {

	@Override
	protected TokenStreamComponents createComponents(String fieldName, Reader reader) {

		Tokenizer tokenizer = new StandardTokenizer(reader);
		TokenStream stream = new ASCIIFoldingFilter(tokenizer);
		stream = new StandardFilter(stream);
		stream = new LowerCaseFilter(stream);
		stream = new SnowballFilter(stream, new PortugueseStemmer());
		stream = new PhoneticFilter(stream, new RefinedSoundex(), true);

		return new TokenStreamComponents(tokenizer, stream);
	}

}
