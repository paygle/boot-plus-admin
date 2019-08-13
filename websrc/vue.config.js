const path = require('path')

function resolve(dir) {
  return path.join(__dirname, dir)
}

module.exports = {
  publicPath:'./',
  lintOnSave: false,
  // productionSourceMap: false,
  // transpileDependencies: [/node_modules\/d3*/ig],
  devServer: {
    port: 8080
  },
  // css: {
  //   loaderOptions: {
  //     postcss: {
  //         plugins: [
  //           require('postcss-pxtorem')({
  //             rootValue : 40, // 换算的基数
  //             propList: ['*']
  //         })
  //       ]
  //     }
  //   }
  // },
  chainWebpack: (config) => {
    config.resolve.alias
      .set('src', resolve('src'))
      .set('assets', resolve('src/assets'))
      .set('components', resolve('src/components'))

    // 不优化压缩，打包后可以在IE调试
    config.optimization.set('minimize', true)
  },
  // configureWebpack: {
  //   externals: {
  //     'vue': 'Vue'
  //   }
  // }
}