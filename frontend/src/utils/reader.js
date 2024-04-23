// reader.js

const fs = require('fs');

class PropertiesReader {
    constructor(filePath) {
        this.properties = {};
        this.loadProperties(filePath);
    }

    loadProperties(filePath) {
        try {
            const data = fs.readFileSync(filePath, 'utf8');
            const lines = data.split('\n');
            for (const line of lines) {
                if (line.trim() && !line.startsWith('#')) {
                    const [key, value] = line.split('=');
                    this.properties[key.trim()] = value.trim();
                }
            }
        } catch (error) {
            console.error('Error loading properties:', error);
        }
    }

    getProperty(key) {
        return this.properties[key];
    }
}

module.exports = PropertiesReader;
