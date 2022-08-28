package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.strategy.AmountHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String DIVIDER = ",";
    private final String inputFile;
    private final String outputFile;
    private final FruitTransaction fruitTransaction;

    public FruitServiceImpl(String inputFile, String outputFile,
                            Map<String, AmountHandler> amountHandlerMap) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        fruitTransaction = new FruitTransactionImpl(amountHandlerMap);
    }

    @Override
    public void fruitService() {
        Reader reader = new ReaderService();
        List<String> inputFruits = reader.readFromFile(inputFile);
        for (int i = 1; i < inputFruits.size(); i++) {
            String[] fruitIncoming = inputFruits.get(i).split(DIVIDER);
            String operation = fruitIncoming[0];
            String fruitName = fruitIncoming[1];
            int fruitAmount = Integer.parseInt(fruitIncoming[2]);
            fruitTransaction.fruitTransaction(fruitName, operation, fruitAmount);
        }
        Writer writer = new WriterService(outputFile, Storage.fruits);
        writer.writeToFile();
    }
}
