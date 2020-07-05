let path = require('path');

module.exports = {
    entry: './src/index.jsx',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, './public'),
        publicPath: '/public/',
    },
    devServer: {
        port: 3000,
        hot: true,
        inline: true,
        contentBase: './src'
    },
    module: {
        rules: [
            {
                test: /\.(css|scss)$/,
                use: ["style-loader", "css-loader", "sass-loader"]
            },
            {
                test: /\.(js|jsx)?$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader",
                    options:{
                        presets:["@babel/preset-env", "@babel/preset-react"],
                        plugins: [
                            "@babel/plugin-proposal-class-properties"
                        ]
                    }
                },
            },
        ]
    }
};