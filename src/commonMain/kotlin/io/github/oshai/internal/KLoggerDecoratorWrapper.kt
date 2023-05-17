package io.github.oshai.internal

import io.github.oshai.KLogger
import io.github.oshai.KLoggerDecorator

internal class KLoggerDecoratorWrapper(
  private val delegate: KLogger,
  private val decorator: KLoggerDecorator
) : KLogger by delegate {

  override fun trace(msg: () -> Any?) {
    decorator.decorate {
      delegate.trace(msg)
    }
  }

  override fun debug(msg: () -> Any?) {
    decorator.decorate {
      delegate.debug(msg)
    }
  }

  override fun info(msg: () -> Any?) {
    decorator.decorate {
      delegate.info(msg)
    }
  }
}

internal inline fun KLogger.decorated(decorator: KLoggerDecorator) = KLoggerDecoratorWrapper(this, decorator)
